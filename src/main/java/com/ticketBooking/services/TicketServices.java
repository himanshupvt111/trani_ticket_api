package com.ticketBooking.services;

import com.ticketBooking.dto.RequestDto;
import com.ticketBooking.dto.ResponseDto;
import java.util.List;

public interface TicketServices {
    void addTicket(RequestDto userDto);
    ResponseDto getTicket(Long ticketNo);
    void deleteTicket(Long ticketNo);
    void updateTicket(RequestDto requestDto, Long ticketNo);
}
