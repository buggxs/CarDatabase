package de.buggxs.mygarage.car.vehicle;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_drive_type")
@AllArgsConstructor
@NoArgsConstructor
public class DriveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name_de")
    private String nameDe;

    @OneToOne(mappedBy = "driveType")
    private VehicleTechnicalDetails vehicleTechnicalDetails;
}
