package de.buggxs.mygarage.car.vehicle.controller;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/car")
public class VehicleApiController {

    private final VehicleService vehicleService;

    @GetMapping
    public Page<Vehicle> showAllVehicles(
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return vehicleService.getAllVehicles(page);
    }

    @GetMapping(value = "/find")
    public List<Vehicle> getVehicleByHsnTsn(
            @RequestParam(value = "hsn", required = false) Optional<String> hsn,
            @RequestParam(value = "tsn", required = false) Optional<String> tsn
    ) {
        return vehicleService.getVehicleByHsnTsn(hsn, tsn);
    }

}
