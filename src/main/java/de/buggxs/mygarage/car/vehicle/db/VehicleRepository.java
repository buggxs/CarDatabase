package de.buggxs.mygarage.car.vehicle.db;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "SELECT vehicles.* FROM vehicles " +
            "INNER JOIN vehicles_details ON vehicles.id = vehicles_details.vehicle_id " +
            "WHERE vehicles_details.tsn_key = (:tsn) " +
            "AND vehicles_details.hsn_key = (:hsn)",
            countQuery = "SELECT count(vehicles.id) FROM vehicles " +
                    "INNER JOIN vehicles_details ON vehicles.id = vehicles_details.vehicle_id " +
                    "WHERE vehicles_details.tsn_key = (:tsn) " +
                    "AND vehicles_details.hsn_key = (:hsn)", nativeQuery = true)
    Page<Vehicle> getAllVehiclesByHsnTsn(@Param("hsn") String hsn, @Param("tsn") String tsn, Pageable pageable);

    @Query(value = "SELECT * FROM vehicles WHERE model LIKE %:name% OR name LIKE %:name%",
            countQuery = "SELECT count(id) FROM vehicles WHERE model LIKE %:name% OR name LIKE %:name%",
            nativeQuery = true)
    Page<Vehicle> getAllVehiclesByName(@Param("name") String name, Pageable pageable);

}
