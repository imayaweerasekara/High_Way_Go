package lk.ijse.highwaygo_backend.controller;

import lk.ijse.highwaygo_backend.dto.SeatDTO;
import lk.ijse.highwaygo_backend.entity.Seat;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/seat")
@CrossOrigin
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSeat(@RequestBody SeatDTO seatDTO) {
        try {
            Seat savedSeat = seatService.save(seatDTO);
            return new ResponseEntity<>(savedSeat, HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{seatId}")
    public ResponseEntity<?> updateSeat(@PathVariable String seatId, @RequestBody SeatDTO seatDTO) {
        try {
            Seat updatedSeat = seatService.update(seatId, seatDTO);
            return ResponseEntity.ok(updatedSeat);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{seatId}")
    public ResponseEntity<?> deleteSeat(@PathVariable String seatId) {
        try {
            seatService.delete(seatId);
            return ResponseEntity.ok("Seat deleted successfully.");
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bus/{busNumber}")
    public ResponseEntity<List<SeatDTO>> getSeatsByBusNumber(@PathVariable String busNumber) {
        List<SeatDTO> seats = seatService.getSeatsByBusNumber(busNumber);
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/bus/{busNumber}/available")
    public ResponseEntity<List<SeatDTO>> getAvailableSeats(@PathVariable String busNumber) {
        List<SeatDTO> seats = seatService.getAvailableSeatsByBusNumber(busNumber);
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        List<SeatDTO> seats = seatService.getAllSeats();
        return ResponseEntity.ok(seats);
    }
}
