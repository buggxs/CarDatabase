package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long id;

    @Column(name = "vehicle_id", insertable = false, updatable = false)
    private Long vehicleId;

    @Column(name = "engine_type")
    private String engineType;

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

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "fuel_type_2")
    private String fuelTypeE;

    @Column(name = "drive_type")
    private String driveType;

    @Column(name = "gear_type")
    private String gearType;

    @Column(name = "gear_amount")
    private String gearAmount;

    @Column(name = "emission_class")
    private String emissionClass;

    @Column(name = "position_engine")
    private String positionEngine;

    @Column(name = "exhaust_gas_cleaning")
    private String exhaustGasCleaning;

    @Column(name = "amount_cylinders")
    private String amountCylinders;

    @Column(name = "mixture_preparation")
    private String mixturePreparation;

    @Column(name = "engine_loading")
    private String engineLoading;

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

}
