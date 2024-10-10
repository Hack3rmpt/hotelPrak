package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomBedModel;

import java.util.List;
import java.util.UUID;

public interface RoomBedService {

    List<RoomBedModel> findAllRoomBeds();

    RoomBedModel findRoomBedById(UUID id);

    RoomBedModel addRoomBed(RoomBedModel roomBed);

    RoomBedModel updateRoomBed(RoomBedModel roomBed);

    void deleteRoomBed(UUID id);

}