package com.hotel.hotelPrak.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "room_bed")
public class RoomBedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomModel room;

    @ManyToOne
    @JoinColumn(name = "bed_type_id", nullable = false)
    private BedTypeModel bedType;


    public RoomBedModel(UUID id, RoomModel room, BedTypeModel bedType) {
        this.id = id;
        this.room = room;
        this.bedType = bedType;
    }
    public RoomBedModel(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public BedTypeModel getBedType() {
        return bedType;
    }

    public void setBedType(BedTypeModel bedType) {
        this.bedType = bedType;
    }
}
