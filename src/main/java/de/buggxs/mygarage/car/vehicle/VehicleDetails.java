package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicles_details")
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "vehicle_id", insertable = false, updatable = false)
    @JsonIgnore
    private Long vehicleId;

    @Column(name = "type")
    private String type;

    @Column(name = "model_start")
    private String modelStart;

    @Column(name = "model_end")
    private String modelEnd;

    @Column(name = "model_series_start")
    private String modelSeriesStart;

    @Column(name = "model_series_end")
    private String modelSeriesEnd;

    @Column(name = "hsn_key")
    private String hsnKey;

    @Column(name = "tsn_key")
    private String tsnKey;

    @Column(name = "kfz_tax")
    private String kfzTax;

    @Column(name = "base_price")
    private String basePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_vehicle_details_vehicle"))
    @JsonBackReference
    @ToString.Exclude
    private Vehicle vehicle;

    public String getModelEnd() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/y");
        LocalDateTime now = LocalDateTime.now();
        return (modelEnd != null) ? modelEnd : dtf.format(now);
    }
}
