package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomModel;

import java.util.List;

public interface RoomService {
    public List<RoomModel> findAllRooms();

    public RoomModel findRoomById(long id);

    public RoomModel addRoom(RoomModel Rooms);

    public RoomModel updateRoom(RoomModel Rooms);

    public void deleteRoom(long id);
}
