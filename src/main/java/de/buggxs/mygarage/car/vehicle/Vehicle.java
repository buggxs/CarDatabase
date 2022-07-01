package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    @JsonIgnore
    private String url;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<VehicleDetails> vehicleDetails;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<VehicleTechnicalDetails> vehicleTechnicalDetails;

    @JsonIgnore
    public VehicleShortDetailed vehicleShortDetailed() {
        if (!this.vehicleDetails.isEmpty()) {
            VehicleDetails vehicleDetailsTemp = this.vehicleDetails.iterator().next();
            return new VehicleShortDetailed(this.id, this.name, this.model, this.type,
                    vehicleDetailsTemp.getModelStart(), vehicleDetailsTemp.getModelEnd());
        }
        return new VehicleShortDetailed(this.name, this.model, this.type);
    }
}
