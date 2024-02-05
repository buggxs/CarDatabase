package de.buggxs.mygarage.car.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.buggxs.mygarage.misc.MyDateAttributeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Convert(converter = MyDateAttributeConverter.class)
    @Column(name = "model_start")
    private LocalDate modelStart;

    @Convert(converter = MyDateAttributeConverter.class)
    @Column(name = "model_end")
    private LocalDate modelEnd;

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

    public VehicleDetails(Long id, Long vehicleId, String modelSeriesStart, String modelSeriesEnd, String hsnKey, String tsnKey, Vehicle vehicle) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.hsnKey = hsnKey;
        this.tsnKey = tsnKey;
        this.modelSeriesStart = modelSeriesStart;
        this.modelSeriesEnd = modelSeriesEnd;
        this.vehicle = vehicle;
    }

    public static LocalDate convertStringToDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-y");
        return LocalDate.parse(date, dtf);
    }

    public String getModelStartAsString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/y");
        LocalDate now = modelStart != null ? modelStart : LocalDate.now();
        return dtf.format(now);
    }

    public String getModelEndAsString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/y");
        LocalDate now = modelEnd != null ? modelEnd : LocalDate.now();
        return dtf.format(now);
    }
}
