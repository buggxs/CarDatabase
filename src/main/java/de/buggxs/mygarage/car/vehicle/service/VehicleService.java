package de.buggxs.mygarage.car.vehicle.service;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.VehicleShortDetailed;
import de.buggxs.mygarage.car.vehicle.db.VehicleRepository;
import de.buggxs.mygarage.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Page<VehicleShortDetailed> getAllVehicles(Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        log.info("Showing vehicles page number {}", pageNumber);
        Pageable firstPageWithTwoElements = PageRequest.of(pageNumber, 20);
        return vehicleRepository.findAll(firstPageWithTwoElements).map(Vehicle::vehicleShortDetailed);
    }

    public Page<Vehicle> getVehicleByHsnTsn(Optional<String> hsn, Optional<String> tsn, Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        String hsnKey = hsn.orElseThrow(() -> new ApiRequestException("No HSN key set."));
        String tsnKey = tsn.orElseThrow(() -> new ApiRequestException("NO TSN key set."));
        log.info("Fetching vehicle by tsn {} and hsn {}", hsnKey, tsnKey);
        Pageable pageRequest = PageRequest.of(pageNumber, 20);
        return vehicleRepository.getAllVehiclesByHsnTsn(hsnKey, tsnKey, pageRequest);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ApiRequestException("No car with this id."));
    }

    public Page<VehicleShortDetailed> getAllVehiclesByName(Optional<String> name, Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        Pageable pageRequest = PageRequest.of(pageNumber, 20);
        return vehicleRepository.getAllVehiclesByName(name.orElseThrow(() -> new ApiRequestException("No name variable found")), pageRequest).map(Vehicle::vehicleShortDetailed);
    }

    public Page<Vehicle> getAllVehiclesByModelYearAndName(String date, String name, Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        Pageable pageRequest = PageRequest.of(pageNumber, 20);
        return vehicleRepository.getAllVehiclesByModelYearAndName(date, name, pageRequest);
    }


}
