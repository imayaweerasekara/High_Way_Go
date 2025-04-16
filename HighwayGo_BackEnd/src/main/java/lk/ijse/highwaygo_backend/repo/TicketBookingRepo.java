package lk.ijse.highwaygo_backend.repo;

import lk.ijse.highwaygo_backend.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketBookingRepo extends JpaRepository<TicketBooking, String> {

    // Custom query to find TicketBooking by passengerId
    Optional<TicketBooking> findByPassengerId(String passengerId);

    // Custom query to find TicketBooking by routeId
    Optional<TicketBooking> findByRouteId(String routeId);

    // Custom query to find TicketBooking by seatId
    Optional<TicketBooking> findBySeatId(String seatId);

    // Optionally, you can add more custom queries depending on your requirements
}
