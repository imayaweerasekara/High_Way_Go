package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.BusDTO;
import lk.ijse.highwaygo_backend.entity.Bus;

import java.util.List;

public interface BusService {
    Bus save(BusDTO busDTO);
    Bus update(String busNumber, BusDTO busDTO);
    void delete(String busNumber);
    List<BusDTO> findAll();
}
