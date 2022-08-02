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

    @Query(value = "SELECT vehicles.* " +
            "FROM vehicles " +
            "INNER JOIN vehicles_details ON vehicles.id = vehicles_details.vehicle_id " +
            "INNER JOIN model_series_generation ON vehicles.model_series_generation_id = model_series_generation.id " +
            "INNER JOIN model_series ON model_series.id = model_series_generation.model_series_id " +
            "INNER JOIN brands ON model_series.brand_id = brands.id " +
            // "WHERE (STR_TO_DATE(:date, '%m/%y') BETWEEN STR_TO_DATE(vehicles_details.model_start, '%m/%y') " +
            // "AND STR_TO_DATE(vehicles_details.model_end, '%m/%y')) " +
            "WHERE model_series_generation.name = :name AND brands.name = :maker",
            countQuery = "SELECT count(vehicles.id) " +
                    "FROM vehicles " +
                    "INNER JOIN vehicles_details ON vehicles.id = vehicles_details.vehicle_id " +
                    "INNER JOIN model_series_generation ON vehicles.model_series_generation_id = model_series_generation.id " +
                    "INNER JOIN model_series ON model_series.id = model_series_generation.model_series_id " +
                    "INNER JOIN brands ON model_series.brand_id = brands.id " +
                    // "WHERE (STR_TO_DATE(:date, '%m/%y') BETWEEN STR_TO_DATE(vehicles_details.model_start, '%m/%y') " +
                    // "AND STR_TO_DATE(vehicles_details.model_end, '%m/%y')) " +
                    "AND model_series_generation.name = :name AND brands.name = :maker",
            nativeQuery = true)
    Page<Vehicle> getAllVehiclesByModelYearAndName(@Param("name") String name, @Param("maker") String maker, Pageable pageable);

}
