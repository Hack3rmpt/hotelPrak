package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.GuestServiceModel;
import com.hotel.hotelPrak.repository.GuestServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GuestServiceModelServiceImpl implements GuestServiceModelService {

    @Autowired
    private GuestServiceRepository guestServiceRepository;

    @Override
    public List<GuestServiceModel> findAllGuestServices() {
        return guestServiceRepository.findAll();
    }

    @Override
    public GuestServiceModel findGuestServiceById(UUID id) {
        return guestServiceRepository.findById(id).orElse(null);
    }

    @Override
    public GuestServiceModel addGuestService(GuestServiceModel guestService) {
        return guestServiceRepository.save(guestService);
    }

    @Override
    public GuestServiceModel updateGuestService(GuestServiceModel guestService) {
        return guestServiceRepository.save(guestService);
    }

    @Override
    public void deleteGuestService(UUID id) {
        guestServiceRepository.deleteById(id);
    }
}