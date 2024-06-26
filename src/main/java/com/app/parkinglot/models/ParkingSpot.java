package com.app.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private Long parkingSpotNumber;
    private Long floorNumber;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;

    public static ParkingSpot mediumAvailable() {
        return ParkingSpot.builder()
                .vehicleType(VehicleType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }
}
