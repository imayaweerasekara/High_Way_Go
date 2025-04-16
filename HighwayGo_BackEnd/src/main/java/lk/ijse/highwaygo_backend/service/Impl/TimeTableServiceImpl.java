package lk.ijse.highwaygo_backend.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.TimeTableDTO;
import lk.ijse.highwaygo_backend.entity.Bus;
import lk.ijse.highwaygo_backend.entity.TimeTable;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.repo.BusRepo;
import lk.ijse.highwaygo_backend.repo.TimeTableRepo;
import lk.ijse.highwaygo_backend.service.TimeTableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private TimeTableRepo timeTableRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TimeTable save(TimeTableDTO dto) {
        Optional<Bus> bus = busRepo.findById(Integer.valueOf(dto.getBusNumber()));
        if (bus.isEmpty()) {
            throw new NotFoundException("Bus not found with number: " + dto.getBusNumber());
        }

        TimeTable timeTable = modelMapper.map(dto, TimeTable.class);
        timeTable.setBus(bus.get());

        TimeTable saved = timeTableRepo.save(timeTable);
        return modelMapper.map(saved, TimeTable.class);
    }

    @Override
    public TimeTable update(String timetableId, TimeTableDTO dto) {
        TimeTable existing = timeTableRepo.findById(timetableId)
                .orElseThrow(() -> new EntityNotFoundException("Timetable not found with ID: " + timetableId));

        if (dto.getRouteFrom() != null) existing.setRouteFrom(dto.getRouteFrom());
        if (dto.getRouteTo() != null) existing.setRouteTo(dto.getRouteTo());
        if (dto.getTravelDate() != null) existing.setTravelDate(dto.getTravelDate());
        if (dto.getDepartureTime() != null) existing.setDepartureTime(dto.getDepartureTime());
        if (dto.getArrivalTime() != null) existing.setArrivalTime(dto.getArrivalTime());
        if (dto.getPrice() > 0) existing.setPrice(dto.getPrice());

        return modelMapper.map(timeTableRepo.save(existing), TimeTable.class);
    }

    @Override
    public void delete(String timetableId) {
        TimeTable timeTable = timeTableRepo.findById(timetableId)
                .orElseThrow(() -> new NotFoundException("Timetable not found with ID: " + timetableId));
        timeTableRepo.delete(timeTable);
    }

    @Override
    public List<TimeTableDTO> getAllTimeTables() {
        return timeTableRepo.findAll()
                .stream()
                .map(t -> modelMapper.map(t, TimeTableDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TimeTable getTimeTableById(String timetableId) {
        TimeTable timeTable = timeTableRepo.findById(timetableId)
                .orElseThrow(() -> new NotFoundException("Timetable not found with ID: " + timetableId));
        return modelMapper.map(timeTable, TimeTable.class);
    }

    @Override
    public List<TimeTableDTO> getTimeTablesByBusNumber(String busNumber) {
        return timeTableRepo.findByBus_BusNumber(busNumber)
                .stream()
                .map(t -> modelMapper.map(t, TimeTableDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TimeTableDTO> searchTimeTables(String routeFrom, String routeTo, String travelDateStr) {
        LocalDate travelDate = LocalDate.parse(travelDateStr);
        return timeTableRepo.findByRouteFromAndRouteToAndTravelDate(routeFrom, routeTo, travelDate)
                .stream()
                .map(t -> modelMapper.map(t, TimeTableDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<TimeTableDTO> findAll() {
        List<TimeTable> timeTables = timeTableRepo.findAll();
        return timeTables.stream()
                .map(t -> modelMapper.map(t, TimeTableDTO.class))
                .collect(Collectors.toList());
    }

}
