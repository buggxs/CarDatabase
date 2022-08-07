package de.buggxs.mygarage.car.vehicle.db;

import de.buggxs.mygarage.car.brand.Brand;
import de.buggxs.mygarage.car.brand.ModelSeries;
import de.buggxs.mygarage.car.brand.ModelSeriesGeneration;
import de.buggxs.mygarage.car.brand.db.BrandRepository;
import de.buggxs.mygarage.car.vehicle.Vehicle;
import de.buggxs.mygarage.car.vehicle.VehicleDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/***
 * If testing with real database data is preferred than uncomment the @Sql annotation
 *
 * Just use one of them. Either sql-script or constants
 *
 */
@DataJpaTest
// @Sql(scripts = {"fill-vehicles.sql"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VehicleRepositoryEmbeddedTest {

    final Brand CONST_BRAND1 = new Brand(1L, "VW", "", Set.of());
    final Brand CONST_BRAND2 = new Brand(2L, "Mercedes", "", Set.of());
    final Brand CONST_BRAND3 = new Brand(3L, "Opel", "", Set.of());
    final Brand[] CONST_BRANDS = {
            CONST_BRAND1,
            CONST_BRAND2,
            CONST_BRAND3,
    };
    final ModelSeries CONST_MODEL_SERIES1 = new ModelSeries(11L, "Arteon", "", CONST_BRANDS[0].getId(), CONST_BRANDS[0], Set.of());
    final ModelSeries CONST_MODEL_SERIES2 = new ModelSeries(12L, "Golf", "", CONST_BRANDS[0].getId(), CONST_BRANDS[0], Set.of());
    final ModelSeries CONST_MODEL_SERIES3 = new ModelSeries(13L, "Tiguan", "", CONST_BRANDS[0].getId(), CONST_BRANDS[0], Set.of());
    final ModelSeries CONST_MODEL_SERIES4 = new ModelSeries(14L, "SL-Klasse", "", CONST_BRANDS[1].getId(), CONST_BRANDS[1], Set.of());
    final ModelSeries[] CONST_MODEL_SERIES = {
            CONST_MODEL_SERIES1,
            CONST_MODEL_SERIES2,
            CONST_MODEL_SERIES3,
            CONST_MODEL_SERIES4,
    };
    final ModelSeriesGeneration CONST_MODEL_SERIES_GEN1 = new ModelSeriesGeneration(11L, "Arteon 1.Generation", "", CONST_MODEL_SERIES[0].getId(), CONST_MODEL_SERIES[0], Set.of());
    final ModelSeriesGeneration CONST_MODEL_SERIES_GEN2 = new ModelSeriesGeneration(12L, "Golf VIII", "", CONST_MODEL_SERIES[1].getId(), CONST_MODEL_SERIES[1], Set.of());
    final ModelSeriesGeneration CONST_MODEL_SERIES_GEN3 = new ModelSeriesGeneration(13L, "Tiguan I", "", CONST_MODEL_SERIES[2].getId(), CONST_MODEL_SERIES[2], Set.of());
    final ModelSeriesGeneration CONST_MODEL_SERIES_GEN4 = new ModelSeriesGeneration(14L, "SL-Klasse 113", "", CONST_MODEL_SERIES[3].getId(), CONST_MODEL_SERIES[3], Set.of());
    final ModelSeriesGeneration[] CONST_MODEL_SERIES_GENERATION = {
            CONST_MODEL_SERIES_GEN1,
            CONST_MODEL_SERIES_GEN2,
            CONST_MODEL_SERIES_GEN3,
            CONST_MODEL_SERIES_GEN4,
    };

    final Vehicle CONST_VEHICLE1 = new Vehicle(11L, "Arteon  (3H)", "", "VW Arteon 1.4 eHybrid OPF Elegance DSG (ab 11/20)", "", CONST_MODEL_SERIES_GENERATION[0].getId(), CONST_MODEL_SERIES_GENERATION[0], null, null);
    final Vehicle CONST_VEHICLE2 = new Vehicle(12L, "Golf  (CD)", "", "VW Golf 1.0 TSI ACTIVE (01/21 - 08/21)", "", CONST_MODEL_SERIES_GENERATION[1].getId(), CONST_MODEL_SERIES_GENERATION[1], null, null);
    final Vehicle CONST_VEHICLE3 = new Vehicle(13L, "Tiguan  (5N)", "", "VW Tiguan 1.4 TSI BMT Cityscape (05/15 - 04/16)", "", CONST_MODEL_SERIES_GENERATION[2].getId(), CONST_MODEL_SERIES_GENERATION[2], null, null);
    final Vehicle CONST_VEHICLE4 = new Vehicle(14L, "SL-Klasse  (W113)", "", "Mercedes 230 SL Automatik (07/63 - 01/67)", "", CONST_MODEL_SERIES_GENERATION[3].getId(), CONST_MODEL_SERIES_GENERATION[3], null, null);
    final Vehicle[] CONST_VEHICLES = {
            CONST_VEHICLE1,
            CONST_VEHICLE2,
            CONST_VEHICLE3,
            CONST_VEHICLE4,
    };
    @Autowired
    private VehicleRepository underTest;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeAll
    public void setup() {
        VehicleDetails CONST_VEHICLE_DETAILS1 = new VehicleDetails(11L, CONST_VEHICLE1.getId(), "03/04", "04/11", "0603", "COQ", CONST_VEHICLE1);
        VehicleDetails CONST_VEHICLE_DETAILS2 = new VehicleDetails(12L, CONST_VEHICLE2.getId(), "03/04", "04/11", "0603", "COQ", CONST_VEHICLE2);
        VehicleDetails CONST_VEHICLE_DETAILS3 = new VehicleDetails(13L, CONST_VEHICLE3.getId(), "03/04", "04/11", "0603", "COQ", CONST_VEHICLE3);
        VehicleDetails CONST_VEHICLE_DETAILS4 = new VehicleDetails(14L, CONST_VEHICLE4.getId(), "03/04", "04/11", "0603", "COQ", CONST_VEHICLE4);

        CONST_VEHICLE1.setVehicleDetails(Set.of(CONST_VEHICLE_DETAILS1));
        CONST_VEHICLE2.setVehicleDetails(Set.of(CONST_VEHICLE_DETAILS2));
        CONST_VEHICLE3.setVehicleDetails(Set.of(CONST_VEHICLE_DETAILS3));
        CONST_VEHICLE4.setVehicleDetails(Set.of(CONST_VEHICLE_DETAILS4));

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

        // vehicleRepository.saveAll(Arrays.asList(CONST_VEHICLES));
        brandRepository.saveAll(Arrays.asList(CONST_BRANDS));
    }

    @Test
    void findAllVehicles_Test() {
        Page<Vehicle> vehiclesPage = underTest.findAll(Pageable.ofSize(20));
        assertThat(vehiclesPage)
                .isNotEmpty()
                .hasSize(4);
    }

    @Test
    void searchByMakerNameAndDate_Test() {
        Page<Vehicle> vehiclePage = underTest.getAllVehiclesByModelMakerAndDate("vw", null, null, Pageable.ofSize(20));
        assertThat(vehiclePage)
                .isNotEmpty();
    }

    @Test
    void getVehiclesByHSNTSN_Test() {
        Page<Vehicle> vehiclePage = underTest.getAllVehiclesByHsnTsn("0603", "COQ", Pageable.ofSize(20));
        assertThat(vehiclePage).isNotEmpty().hasSize(4);
    }

    @Test
    void getAllVehiclesByName_Test() {
        Page<Vehicle> vehiclePage = underTest.getAllVehiclesByName("golf", Pageable.ofSize(20));
        assertThat(vehiclePage).isNotEmpty().hasSize(1);
    }

}
