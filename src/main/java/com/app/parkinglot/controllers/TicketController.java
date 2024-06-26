package com.app.parkinglot.controllers;

import com.app.parkinglot.dtos.CreateTicketRequest;
import com.app.parkinglot.models.Ticket;
import com.app.parkinglot.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;
    // Create a ticket
    // POST /ticket
    // Validation
    // Transformation
    public Ticket createTicket(@RequestBody CreateTicketRequest ticketRequest) {
        return ticketService.createTicket(ticketRequest);
    }

}
