package lk.ijse.highwaygo_backend.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.PassengerDTO;
import lk.ijse.highwaygo_backend.entity.Passenger;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.repo.PassengerRepo;
import lk.ijse.highwaygo_backend.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Passenger save(PassengerDTO passengerDTO) {
        if (passengerRepo.existsById(passengerDTO.getId())) {
            throw new AlreadyExistsException("Passenger with ID " + passengerDTO.getId() + " already exists.");
        }

        // Convert DTO to entity
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        return passengerRepo.save(passenger);
    }

    @Override
    public Passenger update(String id, PassengerDTO passengerDTO) {
        Passenger existingPassenger = passengerRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Passenger not found with ID: " + id));

        // Update fields if provided
        if (passengerDTO.getName() != null) {
            existingPassenger.setName(passengerDTO.getName());
        }
        if (passengerDTO.getEmail() != null) {
            existingPassenger.setEmail(passengerDTO.getEmail());
        }
        if (passengerDTO.getPhoneNumber() != null) {
            existingPassenger.setPhoneNumber(passengerDTO.getPhoneNumber());
        }
        if (passengerDTO.getNic() != null) {
            existingPassenger.setNic(passengerDTO.getNic());
        }

        return passengerRepo.save(existingPassenger);
    }

    @Override
    public void delete(String id) {
        Passenger passenger = passengerRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Passenger with ID " + id + " not found."));

        passengerRepo.delete(passenger);
    }

    @Override
    public List<PassengerDTO> findAll() {
        List<Passenger> passengers = passengerRepo.findAll();
        return passengers.stream()
                .map(passenger -> modelMapper.map(passenger, PassengerDTO.class))
                .collect(Collectors.toList());
    }
}
