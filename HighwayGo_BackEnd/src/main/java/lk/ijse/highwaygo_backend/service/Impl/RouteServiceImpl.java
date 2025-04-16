package lk.ijse.highwaygo_backend.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.RouteDTO;
import lk.ijse.highwaygo_backend.entity.Route;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.repo.RouteRepo;
import lk.ijse.highwaygo_backend.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepo routeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Route save(RouteDTO routeDTO) {
        if (routeRepo.existsById(routeDTO.getId())) {
            throw new AlreadyExistsException("Route with ID " + routeDTO.getId() + " already exists.");
        }

        Route route = modelMapper.map(routeDTO, Route.class);
        return routeRepo.save(route);
    }

    @Override
    public Route update(String routeId, RouteDTO routeDTO) {
        Route existingRoute = routeRepo.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found with ID: " + routeId));

        if (routeDTO.getStartLocation() != null) {
            existingRoute.setStartLocation(routeDTO.getStartLocation());
        }

        if (routeDTO.getEndLocation() != null) {
            existingRoute.setEndLocation(routeDTO.getEndLocation());
        }

        if (routeDTO.getDistanceInKm() > 0) {
            existingRoute.setDistanceInKm(routeDTO.getDistanceInKm());
        }

        if (routeDTO.getBasePrice() > 0) {
            existingRoute.setBasePrice(routeDTO.getBasePrice());
        }

        return routeRepo.save(existingRoute);
    }

    @Override
    public void delete(String routeId) {
        Route route = routeRepo.findById(routeId)
                .orElseThrow(() -> new NotFoundException("Route with ID " + routeId + " not found."));

        routeRepo.delete(route);
    }

    @Override
    public List<RouteDTO> findAll() {
        List<Route> routes = routeRepo.findAll();
        return routes.stream()
                .map(route -> modelMapper.map(route, RouteDTO.class))
                .collect(Collectors.toList());
    }
}
