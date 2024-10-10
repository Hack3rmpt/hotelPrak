package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomTypeModel;
import com.hotel.hotelPrak.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomTypeModel> findAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomTypeModel findRoomTypeById(UUID id) {
        return roomTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RoomTypeModel addRoomType(RoomTypeModel roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomTypeModel updateRoomType(RoomTypeModel roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void deleteRoomType(UUID id) {
        roomTypeRepository.deleteById(id);
    }
}