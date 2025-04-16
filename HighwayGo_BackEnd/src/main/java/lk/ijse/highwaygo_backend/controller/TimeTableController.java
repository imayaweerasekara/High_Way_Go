package lk.ijse.highwaygo_backend.controller;

import jakarta.persistence.EntityNotFoundException;
import lk.ijse.highwaygo_backend.dto.TimeTableDTO;
import lk.ijse.highwaygo_backend.entity.TimeTable;
import lk.ijse.highwaygo_backend.exception.AlreadyExistsException;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/timetable")
@CrossOrigin
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @PostMapping("/save")
    public ResponseEntity<?> saveTimeTable(@RequestBody TimeTableDTO timeTableDTO) {
        try {
            TimeTable saved = timeTableService.save(timeTableDTO);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{timetableId}")
    public ResponseEntity<?> updateTimeTable(@PathVariable String timetableId, @RequestBody TimeTableDTO timeTableDTO) {
        try {
            TimeTable updated = timeTableService.update(timetableId, timeTableDTO);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{timetableId}")
    public ResponseEntity<?> deleteTimeTable(@PathVariable String timetableId) {
        try {
            timeTableService.delete(timetableId);
            return new ResponseEntity<>("Timetable deleted successfully.", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<TimeTableDTO>> getAllTimeTables() {
        List<TimeTableDTO> timeTables = timeTableService.findAll();
        return ResponseEntity.ok(timeTables);
    }
}
