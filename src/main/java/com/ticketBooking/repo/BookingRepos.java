package com.ticketBooking.repo;

import com.ticketBooking.entity.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepos extends JpaRepository<UserTicket,String> {

    void deleteByTicketNo(Long ticketNo);

    Optional<UserTicket> findByTicketNo(Long ticketNo);
}
