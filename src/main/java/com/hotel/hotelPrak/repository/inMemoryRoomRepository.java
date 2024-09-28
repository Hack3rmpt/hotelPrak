package com.hotel.hotelPrak.repository;


import com.hotel.hotelPrak.model.RoomModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class inMemoryRoomRepository {
//    private List<RoomModel> Rooms = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1); //1 это шаг по id
//
//    public List<RoomModel> findAllRooms(){
//        return  new ArrayList<>(Rooms);
//    }
//
//    public RoomModel addRoom(RoomModel room){
//        room.setId(idCounter. getAndIncrement());
//        Rooms.add(room);
//        return room;
//    }
//    public RoomModel updateRoom(RoomModel room){
//        for (int i = 0; i < Rooms.size(); i++){
//            if(Rooms.get(i).getId() == room.getId()){
//                Rooms.set(i, room);
//                return room;
//            }
//        }
//        return null;
//    }
//
//    public void  deleteRooms(int id){
//        Rooms.removeIf(room -> room.getId() == id);
//    }
//
//    public RoomModel fintRoomById(int id){
//        return Rooms.stream().filter(room -> room.getId() == id).findFirst().orElse(null);
//    }
}
