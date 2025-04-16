package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.PassengerDTO;
import lk.ijse.highwaygo_backend.entity.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger save(PassengerDTO passengerDTO);

    Passenger update(String id, PassengerDTO passengerDTO);

    void delete(String id);

    //PassengerDTO getPassengerById(String id);

    //List<PassengerDTO> getAllPassengers();
    List<PassengerDTO> findAll();
}
