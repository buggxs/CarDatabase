package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.buggxs.mygarage.common.LangModel;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_mixture_preparation")
@AllArgsConstructor
@NoArgsConstructor
public class MixturePreparation implements LangModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name_de")
    private String nameDe;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_fr")
    private String nameFr;

    @OneToOne(mappedBy = "mixturePreparation")
    @JsonIgnore
    private VehicleTechnicalDetails vehicleTechnicalDetails;

}
