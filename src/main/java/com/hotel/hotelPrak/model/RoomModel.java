package com.hotel.hotelPrak.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Pattern(regexp = "\\d+", message = "Номер телефона должен содержать только цифры")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private RoomTypeModel roomType;

    private String status;
    private int capacity;

    @OneToMany(mappedBy = "room")
    private List<BookingModel> bookings;

    @OneToMany(mappedBy = "room")
    private List<FeedbackModel> feedbacks;

    public RoomModel(UUID id, String roomNumber, RoomTypeModel roomType, String status, int capacity, List<BookingModel> bookings, List<FeedbackModel> feedbacks) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.capacity = capacity;
        this.bookings = bookings;
        this.feedbacks = feedbacks;
    }

    public RoomModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypeModel getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeModel roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public List<FeedbackModel> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackModel> feedbacks) {
        this.feedbacks = feedbacks;
    }
}