package de.buggxs.mygarage.car.vehicle.db;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {

    @Query(value = "SELECT vehicles.* FROM vehicles " +
            "INNER JOIN vehicles_details ON vehicles.id = vehicles_details.vehicle_id " +
            "WHERE vehicles_details.tsn_key = :tsn " +
            "AND vehicles_details.hsn_key = :hsn", nativeQuery = true)
    List<Vehicle> getAllVehiclesByHsnTsn(@Param("hsn") String hsn, @Param("tsn") String tsn);

}
