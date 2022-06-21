package de.buggxs.mygarage.car.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

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
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    @JsonIgnore
    private String url;

    @ManyToOne
    @JoinColumn(name = "model_series_id", nullable = false)
    private ModelSeries modelSeries;
}
