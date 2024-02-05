package de.buggxs.mygarage.car.vehicle.controller;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.mapper.VehicleShortDetailed;
import de.buggxs.mygarage.car.vehicle.service.VehicleService;
import de.buggxs.mygarage.common.LangModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
            @RequestParam(value = "date", required = false) Optional<String> date,
            @RequestParam(value = "maker", required = false) Optional<String> maker,
            @RequestParam(value = "page", required = false) Optional<Integer> page
    ) {
        return vehicleService.getAllVehiclesByMakerModelAndYear(maker, name, date, page);
    }


    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id,
                                  @RequestParam(value = "lang", required = false) Optional<String> language) {

        return vehicleService.getVehicleById(id, language.orElse(LangModel.GERMAN));
    }

    @GetMapping(value = "/data/update")
    public String updateData() {
        try {
            vehicleService.updateDatabaseData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
