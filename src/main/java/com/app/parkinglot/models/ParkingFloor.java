package com.app.parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private List<ParkingSpot> spots;
    private DisplayBoard displayBoard;
    private PaymentCounter paymentCounter;
}
