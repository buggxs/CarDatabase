package de.buggxs.mygarage.car.vehicle.controller;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.VehicleShortDetailed;
import de.buggxs.mygarage.car.vehicle.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/cars")
public class VehicleApiController {

    private final VehicleService vehicleService;

    @GetMapping
    public Page<VehicleShortDetailed> showAllVehicles(
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return vehicleService.getAllVehicles(page);
    }

    @GetMapping(value = "/hsn/{hsn}/tsn/{tsn}")
    public Page<Vehicle> getVehicleByHsnTsn(
            @PathVariable(value = "hsn") Optional<String> hsn,
            @PathVariable(value = "tsn") Optional<String> tsn,
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return vehicleService.getVehicleByHsnTsn(hsn, tsn, page);
    }


    @GetMapping(value = "/find")
    public Page<VehicleShortDetailed> getVehiclesByName(
            @RequestParam(value = "name", required = false) Optional<String> name,
            @RequestParam(value = "year", required = false) Optional<String> year,
            @RequestParam(value = "maker", required = false) Optional<String> maker,
            @RequestParam(value = "page", required = false) Optional<Integer> page

    ) {
        return vehicleService.getAllVehiclesByMakerModelAndYear(maker, name, year, page);
    }


    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping(value = "/find/year")
    public Page<VehicleShortDetailed> getVehiclesByType(@RequestParam(value = "type", required = false) Optional<String> type) {
        // TODO: implement
        return null;
    }

}
