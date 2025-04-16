package lk.ijse.highwaygo_backend.repo;

import lk.ijse.highwaygo_backend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat, String> {

    // Get all seats for a given bus (using busNumber as foreign key)
    List<Seat> findByBus_BusNumber(String busNumber);

    // Get only the seats that are not booked
    List<Seat> findByBus_BusNumberAndIsBookedFalse(String busNumber);
}
