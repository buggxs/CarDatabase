package de.buggxs.mygarage.car.brand;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.buggxs.mygarage.car.vehicle.Vehicle;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "model_series_generation")
@AllArgsConstructor
@NoArgsConstructor
public class ModelSeriesGeneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    @JsonIgnore
    private String url;

    @Column(name = "model_series_id", insertable = false, updatable = false)
    @JsonIgnore
    private Long modelSeriesId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_series_id", nullable = false, foreignKey = @ForeignKey(name = "FK_model_series_model_series_generation"))
    @JsonBackReference
    private ModelSeries modelSeries;

    @OneToMany(mappedBy = "modelSeriesGeneration", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Set<Vehicle> vehicleList;

    public ModelSeriesGeneration(String name, String url, ModelSeries modelSeries) {
        this.name = name;
        this.url = url;
        this.modelSeries = modelSeries;
    }
}
