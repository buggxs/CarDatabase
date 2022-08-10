package de.buggxs.mygarage.car.brand;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "model_series")
@AllArgsConstructor
@NoArgsConstructor
public class ModelSeries {

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

    @Column(name = "brand_id")
    @JsonIgnore
    private Long brandId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    private Brand brand;

    @JsonProperty("model_series_generations")
    @OneToMany(mappedBy = "modelSeries", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private Set<ModelSeriesGeneration> modelSeriesGenerationSet;

    public ModelSeries(String name, String url, Brand brand) {
        this.name = name;
        this.url = url;
        this.brand = brand;
    }
}
