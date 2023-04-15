package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_exhaust_gas_cleaning")
@AllArgsConstructor
@NoArgsConstructor
public class ExhaustGasCleaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name_de")
    private String nameDe;

    @OneToOne(mappedBy = "exhaustGasCleaning")
    @JsonIgnore
    private VehicleTechnicalDetails vehicleTechnicalDetails;
}
