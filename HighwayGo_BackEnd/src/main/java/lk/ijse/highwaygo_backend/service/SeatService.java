package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.SeatDTO;
import lk.ijse.highwaygo_backend.entity.Seat;

import java.util.List;

public interface SeatService {

    Seat save(SeatDTO seatDTO);

    Seat update(String seatId, SeatDTO seatDTO);

    void delete(String seatId);

    List<SeatDTO> getSeatsByBusNumber(String busNumber);

    List<SeatDTO> getAvailableSeatsByBusNumber(String busNumber);

    List<SeatDTO> getAllSeats();
}
