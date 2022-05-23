package de.buggxs.mygarage.car.vehicle.service;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.db.VehicleRepository;
import de.buggxs.mygarage.exception.ContractDatabaseException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Page<Vehicle> getAllVehicles(Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        log.info("Showing vehicles page number {}", pageNumber);
        Pageable firstPageWithTwoElements = PageRequest.of(pageNumber, 20);
        return vehicleRepository.findAll(firstPageWithTwoElements);
    }

    public List<Vehicle> getVehicleByHsnTsn(Optional<String> hsn, Optional<String> tsn) {
        String hsnKey = hsn.orElseThrow(() -> new ContractDatabaseException(""));
        String tsnKey = tsn.orElseThrow(() -> new ContractDatabaseException(""));
        return vehicleRepository.getAllVehiclesByHsnTsn(hsnKey, tsnKey);
    }

}
