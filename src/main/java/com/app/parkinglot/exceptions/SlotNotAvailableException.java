package com.app.parkinglot.exceptions;

import com.app.parkinglot.models.VehicleType;

public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException(VehicleType vehicleType) {
        super("Slot for " + vehicleType + " type is not available");
    }
}
