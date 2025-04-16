package lk.ijse.highwaygo_backend.repo;

import lk.ijse.highwaygo_backend.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route, String> {

    // Optional: custom finder methods can go here, e.g.
    boolean existsByStartLocationAndEndLocation(String startLocation, String endLocation);
}
