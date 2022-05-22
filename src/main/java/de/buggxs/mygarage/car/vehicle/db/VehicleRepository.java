package de.buggxs.mygarage.car.vehicle.db;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {
}
