package lk.ijse.highwaygo_backend.repo;

import lk.ijse.highwaygo_backend.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeTableRepo extends JpaRepository<TimeTable, String> {

    List<TimeTable> findByBus_BusNumber(String busNumber);

    List<TimeTable> findByRouteFromAndRouteToAndTravelDate(String routeFrom, String routeTo, LocalDate travelDate);
}
