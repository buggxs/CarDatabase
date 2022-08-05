package de.buggxs.mygarage.car.vehicle.db;

import de.buggxs.mygarage.car.brand.Brand;
import de.buggxs.mygarage.car.brand.ModelSeries;
import de.buggxs.mygarage.car.brand.ModelSeriesGeneration;
import de.buggxs.mygarage.car.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VehicleRepositoryEmbeddedTest {

    Brand CONST_BRAND1 = new Brand(1L, "VW", "", Set.of());
    Brand CONST_BRAND2 = new Brand(2L, "Mercedes", "", Set.of());
    Brand CONST_BRAND3 = new Brand(3L, "Opel", "", Set.of());
    final Brand[] CONST_BRANDS = {
            CONST_BRAND1,
            CONST_BRAND2,
            CONST_BRAND3,
    };
    ModelSeries CONST_MODEL_SERIES1 = new ModelSeries(1L, "Arteon", "", CONST_BRANDS[0].getId(), CONST_BRANDS[0], Set.of());
    ModelSeries CONST_MODEL_SERIES2 = new ModelSeries(2L, "Golf", "", CONST_BRANDS[0].getId(), CONST_BRANDS[0], Set.of());
    ModelSeries CONST_MODEL_SERIES3 = new ModelSeries(3L, "Tiguan", "", CONST_BRANDS[0].getId(), CONST_BRANDS[0], Set.of());
    ModelSeries CONST_MODEL_SERIES4 = new ModelSeries(4L, "SL-Klasse", "", CONST_BRANDS[1].getId(), CONST_BRANDS[1], Set.of());
    final ModelSeries[] CONST_MODEL_SERIES = {
            CONST_MODEL_SERIES1,
            CONST_MODEL_SERIES2,
            CONST_MODEL_SERIES3,
            CONST_MODEL_SERIES4,
    };
    ModelSeriesGeneration CONST_MODEL_SERIES_GEN1 = new ModelSeriesGeneration(1L, "Arteon 1.Generation", "", CONST_MODEL_SERIES[0].getId(), CONST_MODEL_SERIES[0], Set.of());
    ModelSeriesGeneration CONST_MODEL_SERIES_GEN2 = new ModelSeriesGeneration(2L, "Golf VIII", "", CONST_MODEL_SERIES[1].getId(), CONST_MODEL_SERIES[1], Set.of());
    ModelSeriesGeneration CONST_MODEL_SERIES_GEN3 = new ModelSeriesGeneration(3L, "Tiguan I", "", CONST_MODEL_SERIES[2].getId(), CONST_MODEL_SERIES[2], Set.of());
    ModelSeriesGeneration CONST_MODEL_SERIES_GEN4 = new ModelSeriesGeneration(4L, "SL-Klasse 113", "", CONST_MODEL_SERIES[3].getId(), CONST_MODEL_SERIES[3], Set.of());
    final ModelSeriesGeneration[] CONST_MODEL_SERIES_GENERATION = {
            CONST_MODEL_SERIES_GEN1,
            CONST_MODEL_SERIES_GEN2,
            CONST_MODEL_SERIES_GEN3,
            CONST_MODEL_SERIES_GEN4,
    };
    Vehicle CONST_VEHICLE1 = new Vehicle(1L, "Arteon  (3H)", "", "VW Arteon 1.4 eHybrid OPF Elegance DSG (ab 11/20)", "", CONST_MODEL_SERIES_GENERATION[0].getId(), CONST_MODEL_SERIES_GENERATION[0], null, null);
    Vehicle CONST_VEHICLE2 = new Vehicle(2L, "Golf  (CD)", "", "VW Golf 1.0 TSI ACTIVE (01/21 - 08/21)", "", CONST_MODEL_SERIES_GENERATION[1].getId(), CONST_MODEL_SERIES_GENERATION[1], null, null);
    Vehicle CONST_VEHICLE3 = new Vehicle(3L, "Tiguan  (5N)", "", "VW Tiguan 1.4 TSI BMT Cityscape (05/15 - 04/16)", "", CONST_MODEL_SERIES_GENERATION[2].getId(), CONST_MODEL_SERIES_GENERATION[2], null, null);
    Vehicle CONST_VEHICLE4 = new Vehicle(4L, "SL-Klasse  (W113)", "", "Mercedes 230 SL Automatik (07/63 - 01/67)", "", CONST_MODEL_SERIES_GENERATION[3].getId(), CONST_MODEL_SERIES_GENERATION[3], null, null);
    final Vehicle[] CONST_VEHICLES = {
            CONST_VEHICLE1,
            CONST_VEHICLE2,
            CONST_VEHICLE3,
            CONST_VEHICLE4,
    };
    @Autowired
    private VehicleRepository vehicleRepository;

    @BeforeEach
    void setUp() {
        CONST_BRAND1.setModelSeriesSet(Set.of(CONST_MODEL_SERIES[0], CONST_MODEL_SERIES[1], CONST_MODEL_SERIES[2]));
        CONST_BRAND2.setModelSeriesSet(Set.of(CONST_MODEL_SERIES[3]));

        CONST_MODEL_SERIES1.setModelSeriesGenerationSet(Set.of(CONST_MODEL_SERIES_GENERATION[0]));
        CONST_MODEL_SERIES2.setModelSeriesGenerationSet(Set.of(CONST_MODEL_SERIES_GENERATION[1]));
        CONST_MODEL_SERIES3.setModelSeriesGenerationSet(Set.of(CONST_MODEL_SERIES_GENERATION[2]));
        CONST_MODEL_SERIES4.setModelSeriesGenerationSet(Set.of(CONST_MODEL_SERIES_GENERATION[3]));

        CONST_MODEL_SERIES_GEN1.setVehicleList(Set.of(CONST_VEHICLES[0]));
        CONST_MODEL_SERIES_GEN2.setVehicleList(Set.of(CONST_VEHICLES[1]));
        CONST_MODEL_SERIES_GEN3.setVehicleList(Set.of(CONST_VEHICLES[2]));
        CONST_MODEL_SERIES_GEN4.setVehicleList(Set.of(CONST_VEHICLES[3]));


        vehicleRepository.saveAll(Arrays.asList(CONST_VEHICLES));
    }

    @Test
    void findAllVehicles_Test() {
        Page<Vehicle> vehiclesPage = vehicleRepository.findAll(Pageable.ofSize(20));
        String testVehicleName = vehiclesPage.getContent().get(0).getName();
        assertThat(vehiclesPage)
                .isNotEmpty()
                .hasSize(4);
        assertThat(testVehicleName).isEqualTo(CONST_VEHICLES[0].getName());
    }

    @Test
    void searchByMakerNameAndDate() {
        Page<Vehicle> vehiclePage = vehicleRepository.getAllVehiclesByModelMakerAndDate("vw", null, null, Pageable.ofSize(20));
        assertThat(vehiclePage)
                .isNotEmpty()
                .hasSize(2)
                .contains(CONST_VEHICLES[0], CONST_VEHICLES[1]);
    }

}
