package lk.ijse.highwaygo_backend.repo;

import lk.ijse.highwaygo_backend.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface BusRepo extends JpaRepository<Bus, Integer> {
    /*Bus findByBusNumber(String busNumber);
    boolean existsByBusNumber(String busNumber);
    void deleteByBusNumber(String busNumber);*/

    Optional<Bus> findByBusNumber(String busNumber);

}
