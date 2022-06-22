package de.buggxs.mygarage.car.vehicle.controller;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/cars")
public class VehicleApiController {

    private final VehicleService vehicleService;

    @GetMapping
    public Page<Vehicle> showAllVehicles(
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return vehicleService.getAllVehicles(page);
    }

    @GetMapping(value = "/hsn/{hsn}/tsn/{tsn}")
    public List<Vehicle> getVehicleByHsnTsn(
            @PathVariable(value = "hsn", required = false) Optional<String> hsn,
            @PathVariable(value = "tsn", required = false) Optional<String> tsn
    ) {
        return vehicleService.getVehicleByHsnTsn(hsn, tsn);
    }


    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.getVehicleById(id);
    }

}
