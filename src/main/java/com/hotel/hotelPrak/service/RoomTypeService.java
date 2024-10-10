package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomTypeModel;

import java.util.List;
import java.util.UUID;

public interface RoomTypeService {

    List<RoomTypeModel> findAllRoomTypes();

    RoomTypeModel findRoomTypeById(UUID id);

    RoomTypeModel addRoomType(RoomTypeModel roomType);

    RoomTypeModel updateRoomType(RoomTypeModel roomType);

    void deleteRoomType(UUID id);

}