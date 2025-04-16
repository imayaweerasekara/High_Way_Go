package lk.ijse.highwaygo_backend.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.SeatDTO;
import lk.ijse.highwaygo_backend.entity.Bus;
import lk.ijse.highwaygo_backend.entity.Seat;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.repo.BusRepo;
import lk.ijse.highwaygo_backend.repo.SeatRepo;
import lk.ijse.highwaygo_backend.service.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Seat save(SeatDTO seatDTO) {
        Bus bus = busRepo.findById(Integer.valueOf(seatDTO.getBusNumber()))
                .orElseThrow(() -> new NotFoundException("Bus not found with number: " + seatDTO.getBusNumber()));

        Seat seat = modelMapper.map(seatDTO, Seat.class);
        seat.setBus(bus);
        Seat savedSeat = seatRepo.save(seat);
        return modelMapper.map(savedSeat, Seat.class);
    }

    @Override
    public Seat update(String seatId, SeatDTO seatDTO) {
        Seat existingSeat = seatRepo.findById(seatId)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with ID: " + seatId));

        // Only update values if present in DTO
        if (seatDTO.getSeatNumber() != null) {
            existingSeat.setSeatNumber(seatDTO.getSeatNumber());
        }
        if (seatDTO.getSeatType() != null) {
            existingSeat.setSeatType(seatDTO.getSeatType());
        }

        existingSeat.setBooked(seatDTO.isBooked());

        Seat updatedSeat = seatRepo.save(existingSeat);
        return modelMapper.map(updatedSeat, Seat.class);
    }

    @Override
    public void delete(String seatId) {
        Seat seat = seatRepo.findById(seatId)
                .orElseThrow(() -> new NotFoundException("Seat not found with ID: " + seatId));
        seatRepo.delete(seat);
    }

    @Override
    public List<SeatDTO> getSeatsByBusNumber(String busNumber) {
        List<Seat> seats = seatRepo.findByBus_BusNumber(busNumber);
        return seats.stream()
                .map(seat -> modelMapper.map(seat, SeatDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SeatDTO> getAvailableSeatsByBusNumber(String busNumber) {
        List<Seat> seats = seatRepo.findByBus_BusNumberAndIsBookedFalse(busNumber);
        return seats.stream()
                .map(seat -> modelMapper.map(seat, SeatDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SeatDTO> getAllSeats() {
        List<Seat> seats = seatRepo.findAll();
        return seats.stream()
                .map(seat -> modelMapper.map(seat, SeatDTO.class))
                .collect(Collectors.toList());
    }
}
