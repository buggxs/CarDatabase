package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_fuel_type")
@AllArgsConstructor
@NoArgsConstructor
public class FuelType2 implements LangModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name_de")
    private String nameDe;

    @OneToOne(mappedBy = "fuelType2")
    @JsonIgnore
    private VehicleTechnicalDetails vehicleTechnicalDetails;

    @Override
    public String getNameEn() {
        return null;
    }

    @Override
    public String getNameFr() {
        return null;
    }
}
