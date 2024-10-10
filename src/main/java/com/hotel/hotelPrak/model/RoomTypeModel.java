package com.hotel.hotelPrak.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "room_type")
public class RoomTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;

    private String name;
    private String description;
    private double pricePerNight;

    @OneToMany(mappedBy = "roomType")
    private List<RoomModel> rooms;


    public RoomTypeModel(UUID id, String name, String description, double pricePerNight, List<RoomModel> rooms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
    }
    public RoomTypeModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<RoomModel> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomModel> rooms) {
        this.rooms = rooms;
    }
}
