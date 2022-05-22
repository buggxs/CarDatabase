package de.buggxs.mygarage.car.vehicle;

import lombok.*;

import javax.persistence.*;

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
    private Long id;

    @Column(name = "vehicle_id")
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
}
