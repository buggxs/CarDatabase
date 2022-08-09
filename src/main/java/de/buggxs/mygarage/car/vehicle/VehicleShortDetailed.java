package de.buggxs.mygarage.car.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleShortDetailed {

    private Long id;

    private String model;
    private String type;
    private String name;


    private String modelStart;

    private String modelEnd;

    public VehicleShortDetailed(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
