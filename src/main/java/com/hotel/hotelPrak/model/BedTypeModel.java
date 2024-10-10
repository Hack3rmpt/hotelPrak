package com.hotel.hotelPrak.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "bed_type")
public class BedTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "bedType")
    private List<RoomBedModel> roomBeds;

    public BedTypeModel(UUID id, String name, List<RoomBedModel> roomBeds) {
        this.id = id;
        this.name = name;
        this.roomBeds = roomBeds;
    }
    public BedTypeModel(){
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

    public List<RoomBedModel> getRoomBeds() {
        return roomBeds;
    }

    public void setRoomBeds(List<RoomBedModel> roomBeds) {
        this.roomBeds = roomBeds;
    }
}
