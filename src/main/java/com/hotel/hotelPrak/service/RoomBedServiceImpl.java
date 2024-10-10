package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.RoomBedModel;
import com.hotel.hotelPrak.repository.RoomBedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomBedServiceImpl implements RoomBedService {

    @Autowired
    private RoomBedRepository roomBedRepository;

    @Override
    public List<RoomBedModel> findAllRoomBeds() {
        return roomBedRepository.findAll();
    }

    @Override
    public RoomBedModel findRoomBedById(UUID id) {
        return roomBedRepository.findById(id).orElse(null);
    }

    @Override
    public RoomBedModel addRoomBed(RoomBedModel roomBed) {
        return roomBedRepository.save(roomBed);
    }

    @Override
    public RoomBedModel updateRoomBed(RoomBedModel roomBed) {
        return roomBedRepository.save(roomBed);
    }

    @Override
    public void deleteRoomBed(UUID id) {
        roomBedRepository.deleteById(id);
    }
}