package com.app.parkinglot.dtos;

import com.app.parkinglot.models.BaseModel;
import com.app.parkinglot.models.Gate;
import com.app.parkinglot.models.VehicleType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CreateTicketRequest extends BaseModel {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;
}
