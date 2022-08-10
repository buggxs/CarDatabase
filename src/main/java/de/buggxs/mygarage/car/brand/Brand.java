package de.buggxs.mygarage.car.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    @JsonIgnore
    private String url;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Set<ModelSeries> modelSeriesSet;

    public Brand(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
}
