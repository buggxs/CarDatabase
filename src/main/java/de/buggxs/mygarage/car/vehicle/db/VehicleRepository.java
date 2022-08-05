package de.buggxs.mygarage.car.vehicle.db;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

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

    @Query(value = "SELECT v " +
            "FROM Vehicle v " +
            "INNER JOIN v.vehicleDetails vd " +
            "INNER JOIN v.modelSeriesGeneration msg " +
            "INNER JOIN msg.modelSeries ms " +
            "INNER JOIN ms.brand b " +
            "WHERE ((:date IS NULL) OR (:date BETWEEN vd.modelStart AND vd.modelEnd)) " +
            "AND ((:name IS NUll) OR (msg.name LIKE %:name%)) " +
            "AND ((:maker IS NULL) OR (b.name LIKE %:maker%))",
            countQuery = "SELECT COUNT(v) " +
                    "FROM Vehicle v " +
                    "INNER JOIN v.vehicleDetails vd " +
                    "INNER JOIN v.modelSeriesGeneration msg " +
                    "INNER JOIN msg.modelSeries ms " +
                    "INNER JOIN ms.brand b " +
                    "WHERE ((:date IS NULL) OR (function('date_format', :date, '%m/%y') BETWEEN function('date_format', vd.modelStart , '%m/%y') " +
                    "       AND function('date_format', vd.modelEnd, '%m/%y'))) " +
                    "AND ((:name IS NUll) OR (msg.name LIKE %:name%)) " +
                    "AND ((:maker IS NULL) OR (b.name LIKE %:maker%))")
    Page<Vehicle> getAllVehiclesByModelMakerAndDate(@Param("maker") String maker, @Param("name") String name, @Param("date") LocalDate date, Pageable pageable);

}
