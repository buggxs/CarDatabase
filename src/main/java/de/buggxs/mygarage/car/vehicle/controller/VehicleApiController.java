package de.buggxs.mygarage.car.vehicle.controller;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/car")
public class VehicleApiController {

    private final VehicleService vehicleService;

    @GetMapping
    public Page<Vehicle> showAllVehicles() {
        return vehicleService.getAllVehicles();
    }

}
