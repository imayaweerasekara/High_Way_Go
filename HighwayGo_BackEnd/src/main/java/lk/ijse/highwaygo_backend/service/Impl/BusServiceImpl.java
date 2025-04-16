package lk.ijse.highwaygo_backend.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.BusDTO;
import lk.ijse.highwaygo_backend.entity.Bus;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.repo.BusRepo;
import lk.ijse.highwaygo_backend.service.BusService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service

public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepo busRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Bus save(BusDTO busDTO) {
        if (busRepo.existsById(Integer.valueOf(busDTO.getBusNumber()))) {
            throw new AlreadyExistsException("Bus with number " + busDTO.getBusNumber() + " already exists.");
        }

        // Convert DTO to entity
        Bus bus = modelMapper.map(busDTO, Bus.class);


        // Save the bus
        return busRepo.save(bus);
    }

    @Override
    public Bus update(String busNumber, BusDTO busDTO) {
        Bus existingBus = busRepo.findByBusNumber(busNumber)
                .orElseThrow(() -> new EntityNotFoundException("Bus not found with number: " + busNumber));
        System.out.println("Bus Number3: " + busDTO.getBusNumber());


        // Update fields if provided
        if (busDTO.getBusType() != null) {
            existingBus.setBusType(busDTO.getBusType());
        }
        System.out.println("Bus Number4: " + busDTO.getBusNumber());

        if (busDTO.getTotalSeats() > 0) {
            existingBus.setTotalSeats(busDTO.getTotalSeats());
        }
        System.out.println("Bus Number5: " + busDTO.getBusNumber());

        if (busDTO.getOperatorName() != null) {
            existingBus.setOperatorName(busDTO.getOperatorName());
        }
        System.out.println("Bus Number6: " + busDTO.getBusNumber());

        if (busDTO.getContactNumber() != null) {
            existingBus.setContactNumber(busDTO.getContactNumber());
        }
        System.out.println("Bus Number7: " + busDTO.getBusNumber());

        existingBus.setAvailable(busDTO.isAvailable());
        System.out.println("Bus Number8: " + busDTO.getBusNumber());


        // Save updated bus
        return busRepo.save(existingBus);


    }

    @Override
    public void delete(String busNumber) {
        Bus bus = busRepo.findByBusNumber(busNumber)
                .orElseThrow(() -> new NotFoundException("Bus with number " + busNumber + " not found."));


        // Delete bus
        busRepo.delete(bus);

    }

    @Override
    public List<BusDTO> findAll() {
        /*List<Bus> buses = busRepo.findAll();
        return buses.stream()
                .map(bus -> modelMapper.map(bus, BusDTO.class))
                .collect(Collectors.toList());*/
        return List.of();
    }
}
