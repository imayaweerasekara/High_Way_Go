package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.TimeTableDTO;
import lk.ijse.highwaygo_backend.entity.TimeTable;

import java.util.List;

public interface TimeTableService {

    TimeTable save(TimeTableDTO timeTableDTO);

    TimeTable update(String timetableId, TimeTableDTO timeTableDTO);

    void delete(String timetableId);

    List<TimeTableDTO> getAllTimeTables();

    TimeTable getTimeTableById(String timetableId);

    List<TimeTableDTO> getTimeTablesByBusNumber(String busNumber);

    List<TimeTableDTO> searchTimeTables(String routeFrom, String routeTo, String travelDate);

    List<TimeTableDTO> findAll();
}
