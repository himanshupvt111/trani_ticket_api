package com.ticketBooking.services;

import com.ticketBooking.dto.RequestDto;
import com.ticketBooking.dto.ResponseDto;
import com.ticketBooking.entity.UserTicket;
import com.ticketBooking.repo.BookingRepos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketServicesImpl implements  TicketServices {
  private final BookingRepos ticketRepository;

    public TicketServicesImpl(BookingRepos ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void addTicket(RequestDto userDto) {
      UserTicket ticket = new UserTicket();
      ticket.setName(userDto.getName());
      ticket.setAge(userDto.getAge());
      ticket.setEmail(userDto.getEmail());
      ticket.setNumberOfPassengers(userDto.getNumberOfPassengers());
      ticket.setDateOfJourney(userDto.getDateOfJourney());
      ticket.setBoardingStation(userDto.getBoardingStation());
      ticket.setDeboardingStation(userDto.getBoardingStation());
      ticketRepository.save(ticket);

    }

    @Override
    public ResponseDto getTicket(Long ticketNo) {
      Optional<UserTicket> ticketOpt = ticketRepository.findByTicketNo(ticketNo);
      if(ticketOpt.isPresent()){
        UserTicket ticket = ticketOpt.get();
        return mapToResponseDto(ticket);
      }

  return null;
    }



  @Override
  @Transactional
    public void deleteTicket(Long ticketNo) {
        ticketRepository.deleteByTicketNo(ticketNo);
    }

    @Override
    public void updateTicket(RequestDto requestDto, Long ticketNo) {
        Optional<UserTicket> ticketOpt = ticketRepository.findByTicketNo(ticketNo);
        if (ticketOpt.isPresent()) {
            UserTicket ticket = ticketOpt.get();
            ticket.setName(requestDto.getName());
            ticket.setAge(requestDto.getAge());
            ticket.setEmail(requestDto.getEmail());
            ticket.setNumberOfPassengers(requestDto.getNumberOfPassengers());
            ticket.setDateOfJourney(requestDto.getDateOfJourney());
            ticket.setBoardingStation(requestDto.getBoardingStation());
            ticket.setDeboardingStation(requestDto.getDeboardingStation());
            ticketRepository.save(ticket);
        }
    }

  private ResponseDto mapToResponseDto(UserTicket ticket) {
      ResponseDto responce = new ResponseDto();
      responce.setTicketNo(ticket.getTicketNo());
      responce.setName(ticket.getName());
      responce.setAge(ticket.getAge());
      responce.setNumberOfPassengers(ticket.getNumberOfPassengers());
      responce.setDateOfJourney(ticket.getDateOfJourney());
      responce.setBoardingStation(ticket.getBoardingStation());
      responce.setDeboardingStation(ticket.getDeboardingStation());
      responce.setAmountPaid(calculateAmount(ticket.getNumberOfPassengers()));

      return responce;
  }

 private Double calculateAmount(String numberOfPassengers){
      int passengers = Integer.parseInt(numberOfPassengers);

      double randomFare = ThreadLocalRandom.current().nextDouble(300,1000);
      return  passengers * randomFare;
 }
}

