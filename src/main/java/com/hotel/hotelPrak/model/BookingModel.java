package com.hotel.hotelPrak.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String bookingStatus;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestModel guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomModel room;

    public BookingModel(UUID id, LocalDate checkInDate, LocalDate checkOutDate, String bookingStatus, GuestModel guest, RoomModel room) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingStatus = bookingStatus;
        this.guest = guest;
        this.room = room;
    }
    public BookingModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public GuestModel getGuest() {
        return guest;
    }

    public void setGuest(GuestModel guest) {
        this.guest = guest;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }
}
