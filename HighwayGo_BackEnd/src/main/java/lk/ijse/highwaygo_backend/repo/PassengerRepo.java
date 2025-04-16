package lk.ijse.highwaygo_backend.repo;

import lk.ijse.highwaygo_backend.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, String> {
    // You can define custom queries here if needed, like:
     Optional<Passenger> findByEmail(String email);
}
