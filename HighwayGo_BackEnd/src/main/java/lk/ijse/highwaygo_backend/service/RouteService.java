package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.RouteDTO;
import lk.ijse.highwaygo_backend.entity.Route;

import java.util.List;

public interface RouteService {

    Route save(RouteDTO routeDTO);

    Route update(String routeId, RouteDTO routeDTO);

    void delete(String routeId);

    List<RouteDTO> findAll();
}
