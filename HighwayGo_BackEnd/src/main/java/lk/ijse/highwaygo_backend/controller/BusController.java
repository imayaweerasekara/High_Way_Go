package lk.ijse.highwaygo_backend.controller;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.BusDTO;
import lk.ijse.highwaygo_backend.entity.Bus;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bus")
@CrossOrigin
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping("/save")
    public ResponseEntity<?> saveBus(@RequestBody BusDTO busDTO) {
        try {
            Bus savedBus = busService.save(busDTO);
            return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{busNumber}")
    public ResponseEntity<?> updateBus(@PathVariable String busNumber, @RequestBody BusDTO busDTO) {
        try {
            Bus updatedBus = busService.update(busNumber, busDTO);
            return ResponseEntity.ok(updatedBus);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{busNumber}")
    public ResponseEntity<?> deleteBus(@PathVariable String busNumber) {
        try {
            busService.delete(busNumber);
            return new ResponseEntity<>("Bus deleted successfully.", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusDTO>> getAllBuses() {
        List<BusDTO> buses = busService.findAll();
        return ResponseEntity.ok(buses);
    }
}
