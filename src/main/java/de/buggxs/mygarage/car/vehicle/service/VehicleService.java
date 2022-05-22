package de.buggxs.mygarage.car.vehicle.service;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.db.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Page<Vehicle> getAllVehicles() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 20);
        return vehicleRepository.findAll(firstPageWithTwoElements);
    }

}
