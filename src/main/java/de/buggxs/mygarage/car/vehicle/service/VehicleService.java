package de.buggxs.mygarage.car.vehicle.service;

import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.VehicleDetails;
import de.buggxs.mygarage.car.vehicle.db.VehicleRepository;
import de.buggxs.mygarage.car.vehicle.mapper.VehicleShortDetailed;
import de.buggxs.mygarage.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

    public Vehicle getVehicleById(Long id, String lang) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new ApiRequestException("No car with this id."));
        vehicle.setLang(lang);
        return vehicle;
    }

    public Page<VehicleShortDetailed> getAllVehiclesByName(Optional<String> name, Optional<Integer> page) {
        int pageNumber = page.orElse(0);
        Pageable pageRequest = PageRequest.of(pageNumber, 20);
        return vehicleRepository.getAllVehiclesByName(name.orElseThrow(() -> new ApiRequestException("No name variable found")), pageRequest).map(Vehicle::vehicleShortDetailed);
    }

    public Page<VehicleShortDetailed> getAllVehiclesByMakerModelAndYear(
            Optional<String> maker,
            Optional<String> name,
            Optional<String> date,
            Optional<Integer> page
    ) {
        int pageNumber = page.orElse(0);
        Pageable pageRequest = PageRequest.of(pageNumber, 20);
        Page<Vehicle> vehicles =
                vehicleRepository.getAllVehiclesByModelMakerAndDate(
                        // We can't pass NULL for LIKE queries because it will distort the results
                        maker.orElse(""), name.orElse(""), date.map(VehicleDetails::convertStringToDate).orElse(null), pageRequest
                );

        return vehicles.map(Vehicle::vehicleShortDetailed);
    }

    public void updateDatabaseData() throws IOException {
        List<Vehicle> vehiclePage = vehicleRepository.findAll();
        File file = new File("date_update.sql");
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Vehicle vehicle : vehiclePage) {
            String type = vehicle.getType();
            int index = type.lastIndexOf('(');
            String date = type.substring(index);
            System.out.println(date);
            if (date.contains("ab")) {
                String insertDate = date.replace("(ab", "").replace(")", "").strip();
                String sql = String.format("UPDATE vehicles_details SET model_start = '%s' WHERE vehicle_id = %d;", insertDate, vehicle.getId());
                bw.write(sql);
                bw.newLine();
            } else {
                List<String> insertDates = Arrays.stream(date.replace("(", "").replace(")", "").split("-")).toList();
                String sql = String.format("UPDATE vehicles_details SET model_start = '%s', model_end = '%s' WHERE vehicle_id = %d;", insertDates.get(0).strip(), insertDates.get(1).strip(), vehicle.getId());
                bw.write(sql);
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

}
