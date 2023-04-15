package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_details_technically")
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTechnicalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "vehicle_id", insertable = false, updatable = false)
    @JsonIgnore
    private Long vehicleId;

    @OneToOne
    @JoinColumn(name = "engine_type", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_engine_type"))
    private EngineType engineType;

    @Column(name = "engine_code")
    private String engineCode;

    @Column(name = "rated_capacity")
    private String ratedCapacity;

    @Column(name = "kw_system_performance")
    private String kwSystemPerformance;

    @Column(name = "ps_system_performance")
    private String psSystemPerformance;

    @Column(name = "torque")
    private String torque;

    @OneToOne
    @JoinColumn(name = "fuel_type", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_fuel_type"))
    private FuelType fuelType;

    @OneToOne
    @JoinColumn(name = "fuel_type_2", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_fuel_type_2"))
    private FuelType2 fuelType2;

    @OneToOne
    @JoinColumn(name = "drive_type", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_drive_type"))
    private DriveType driveType;

    @OneToOne
    @JoinColumn(name = "gear_type", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_gear_type"))
    private GearType gearType;

    @Column(name = "gear_amount")
    private String gearAmount;

    @OneToOne
    @JoinColumn(name = "emission_class", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_emission_class"))
    private EmissionClass emissionClass;

    @OneToOne
    @JoinColumn(name = "position_engine", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_position_engine"))
    private PositionEngine positionEngine;

    @OneToOne
    @JoinColumn(name = "exhaust_gas_cleaning", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_exhaust_gas_cleaning"))
    private ExhaustGasCleaning exhaustGasCleaning;

    @Column(name = "amount_cylinders")
    private String amountCylinders;

    @OneToOne
    @JoinColumn(name = "mixture_preparation", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_mixture_preparation"))
    private MixturePreparation mixturePreparation;

    @OneToOne
    @JoinColumn(name = "engine_loading", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles_engine_loading"))
    private EngineLoading engineLoading;

    @Column(name = "amount_valves")
    private String amountValves;

    @Column(name = "displacement")
    private String displacement;

    @Column(name = "max_power_rpm")
    private String maxPowerRpm;

    @Column(name = "max_torque_rpm")
    private String maxTorqueRpm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicles_details_technically_vehicles"))
    @JsonBackReference
    @ToString.Exclude
    private Vehicle vehicle;

    public String getDriveType() {
        if (driveType != null)
            return driveType.getNameDe();
        else return null;
    }

    public String getEngineType() {
        if (engineType != null)
            return engineType.getNameDe();
        else return null;
    }

    public String getFuelType() {
        if (fuelType != null)
            return fuelType.getNameDe();
        else return null;
    }

    public String getFuelType2() {
        if (fuelType2 != null)
            return fuelType2.getNameDe();
        else return null;
    }

    public String getGearType() {
        if (gearType != null)
            return gearType.getNameDe();
        else return null;
    }

    public String getEmissionClass() {
        if (emissionClass != null)
            return emissionClass.getNameDe();
        else return null;
    }

    public String getPositionEngine() {
        if (positionEngine != null)
            return positionEngine.getNameDe();
        else return null;
    }

    public String getExhaustGasCleaning() {
        if (exhaustGasCleaning != null)
            return exhaustGasCleaning.getNameDe();
        else return null;
    }

    public String getMixturePreparation() {
        if (mixturePreparation != null)
            return mixturePreparation.getNameDe();
        else return null;
    }

    public String getEngineLoading() {
        if (engineLoading != null)
            return engineLoading.getNameDe();
        else return null;
    }
}
