package de.buggxs.mygarage.car.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleShortDetailed {

    private Long id;

    private String name;

    private String model;

    private String type;

    private String modelStart;

    private String modelEnd;

    public VehicleShortDetailed(String name, String model, String type) {
        this.name = name;
        this.model = model;
        this.type = type;
    }
}
