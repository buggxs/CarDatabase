package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.buggxs.mygarage.car.brand.ModelSeriesGeneration;
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
    @Column(name = "model_series_generation_id", updatable = false, insertable = false)
    @JsonIgnore
    private Long modelSeriesGenerationId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "model_series_generation_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_model_series_generation_vehicle"))
    @JsonBackReference
    @ToString.Exclude
    private ModelSeriesGeneration modelSeriesGeneration;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private Set<VehicleDetails> vehicleDetails;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private Set<VehicleTechnicalDetails> vehicleTechnicalDetails;

    public Vehicle(String name, String model, String type, String url, ModelSeriesGeneration modelSeriesGeneration, Set<VehicleDetails> vehicleDetails, Set<VehicleTechnicalDetails> vehicleTechnicalDetails) {
        this.name = name;
        this.model = model;
        this.type = type;
        this.url = url;
        this.modelSeriesGeneration = modelSeriesGeneration;
        this.vehicleDetails = vehicleDetails;
        this.vehicleTechnicalDetails = vehicleTechnicalDetails;
    }

    @JsonIgnore
    public VehicleShortDetailed vehicleShortDetailed() {
        VehicleShortDetailed vehicleShortDetailed = new VehicleShortDetailed(this.id, this.name, this.type);

        if (this.vehicleDetails != null && !this.vehicleDetails.isEmpty()) {
            VehicleDetails vehicleDetailsTemp = this.vehicleDetails.iterator().next();
            vehicleShortDetailed.setModelStart(vehicleDetailsTemp.getModelStartAsString());
            vehicleShortDetailed.setModelEnd(vehicleDetailsTemp.getModelEndAsString());
        }

        if (this.modelSeriesGeneration != null) {
            vehicleShortDetailed.setModel(this.modelSeriesGeneration.getName());
        }

        return vehicleShortDetailed;
    }

}
