package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_engine_loading")
@AllArgsConstructor
@NoArgsConstructor
public class EngineLoading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name_de")
    private String nameDe;

    @OneToOne(mappedBy = "engineLoading")
    @JsonIgnore
    private VehicleTechnicalDetails vehicleTechnicalDetails;
}
