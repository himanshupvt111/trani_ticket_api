package com.ticketBooking.controller;

import com.ticketBooking.dto.RequestDto;
import com.ticketBooking.dto.ResponseDto;
import com.ticketBooking.services.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketServices ticketServices;

    @PostMapping("/book")
    public String bookTicket(@RequestBody RequestDto requestDto){
        ticketServices.addTicket(requestDto);
        return "Ticket booked successfully";
    }


    @GetMapping("/{ticketNo}")
    public ResponseDto getTicket(@PathVariable Long ticketNo){
        return ticketServices.getTicket(ticketNo);
    }

    @DeleteMapping("/{ticketNo}")
    public String deleteTicket(@PathVariable Long ticketNo){
        ticketServices.deleteTicket(ticketNo);
        return "Ticket Deleted successfully";
    }


    @PutMapping("/{ticketNo}")
    public String updateTicket(@RequestBody RequestDto requestDto, @PathVariable Long ticketNo){
        ticketServices.updateTicket(requestDto,ticketNo);
        return "Ticket updated successfully";
    }

}
