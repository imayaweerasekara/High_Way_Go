package lk.ijse.highwaygo_backend.controller;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.PassengerDTO;
import lk.ijse.highwaygo_backend.entity.Passenger;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passenger")
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/save")
    public ResponseEntity<?> savePassenger(@RequestBody PassengerDTO passengerDTO) {
        try {
            Passenger savedPassenger = passengerService.save(passengerDTO);
            return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePassenger(@PathVariable String id, @RequestBody PassengerDTO passengerDTO) {
        try {
            Passenger updatedPassenger = passengerService.update(id, passengerDTO);
            return ResponseEntity.ok(updatedPassenger);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePassenger(@PathVariable String id) {
        try {
            passengerService.delete(String.valueOf(id));
            return new ResponseEntity<>("Passenger deleted successfully.", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        List<PassengerDTO> passengers = passengerService.findAll();
        return ResponseEntity.ok(passengers);
    }
}
