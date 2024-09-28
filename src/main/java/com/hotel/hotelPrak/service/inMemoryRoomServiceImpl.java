package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomModel;
import com.hotel.hotelPrak.repository.RoomRepository;
import  org.springframework.stereotype.Service;
import java.util.List;
@Service
public class inMemoryRoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public inMemoryRoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomModel> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public RoomModel findRoomById(long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public RoomModel addRoom(RoomModel Rooms) {
        return roomRepository.save(Rooms);
    }

    @Override
    public RoomModel updateRoom(RoomModel Rooms) {
        if(roomRepository.existsById(Rooms.getId())){
            return roomRepository.save(Rooms);
        }
        return null;
    }

    @Override
    public void deleteRoom(long id) {
        if (roomRepository.existsById(id)){
            roomRepository.deleteById(id);
        }
    }

}
