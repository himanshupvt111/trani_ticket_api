package com.ticketBooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Let DB handle ID generation
    private Long id;

    private Long ticketNo;
    private String name;
    private String age;
    private String email;
    private String numberOfPassengers; // Fixed typo
    private String dateOfJourney;
    private String boardingStation; // Fixed typo
    private String deboardingStation;

    @PrePersist
    public void generateRandomTicketNo() {
        if (ticketNo == null) {
            ticketNo = ThreadLocalRandom.current().nextLong(1000000, 9999999); // 7-digit random ticket number
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(String numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public String getBoardingStation() {
        return boardingStation;
    }

    public void setBoardingStation(String boardingStation) {
        this.boardingStation = boardingStation;
    }

    public String getDeboardingStation() {
        return deboardingStation;
    }

    public void setDeboardingStation(String deboardingStation) {
        this.deboardingStation = deboardingStation;
    }
}
