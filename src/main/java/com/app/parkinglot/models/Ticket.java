package com.app.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class Ticket extends BaseModel {
    private Long vehicleId;
    private Vehicle vehicle;

    private Long parkingSpotId;
    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;

    private Long entryGateId;
    private Gate entryGate;

}
