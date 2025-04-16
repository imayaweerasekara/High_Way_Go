package lk.ijse.highwaygo_backend.controller;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.RouteDTO;
import lk.ijse.highwaygo_backend.entity.Route;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
@CrossOrigin
public class RouteController {

    @Autowired
    private RouteService routeService;

    // Save a new route
    @PostMapping("/save")
    public ResponseEntity<?> saveRoute(@RequestBody RouteDTO routeDTO) {
        try {
            Route savedRoute = routeService.save(routeDTO);
            return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Update an existing route
    @PutMapping("/update/{routeId}")
    public ResponseEntity<?> updateRoute(@PathVariable String routeId, @RequestBody RouteDTO routeDTO) {
        try {
            Route updatedRoute = routeService.update(routeId, routeDTO);
            return ResponseEntity.ok(updatedRoute);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Delete a route
    @DeleteMapping("/delete/{routeId}")
    public ResponseEntity<?> deleteRoute(@PathVariable String routeId) {
        try {
            routeService.delete(routeId);
            return new ResponseEntity<>("Route deleted successfully.", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get all routes
    @GetMapping("/all")
    public ResponseEntity<List<RouteDTO>> getAllRoutes() {
        List<RouteDTO> routes = routeService.findAll();
        return ResponseEntity.ok(routes);
    }
}
