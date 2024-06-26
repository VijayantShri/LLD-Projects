package com.app.parkinglot.controllers;

import com.app.parkinglot.models.ParkingSpot;

public class ParkingSpotController {

    // Create a parking spot
    // POST /parking-spot
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpot;
    }

    // Update a parking spot
    // PUT /parking-spot/{id}

    // Get parking spot
    // GET /parking-spot/{id}
    public ParkingSpot getParkingSpot(Long parkingSpotId) {
        return null;
    }

    // Delete parking spot
    // DELETE /parking-spot/{id}

}
