package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.GuestServiceModel;

import java.util.List;
import java.util.UUID;

public interface GuestServiceModelService {

    List<GuestServiceModel> findAllGuestServices();

    GuestServiceModel findGuestServiceById(UUID id);

    GuestServiceModel addGuestService(GuestServiceModel guestService);

    GuestServiceModel updateGuestService(GuestServiceModel guestService);

    void deleteGuestService(UUID id);

}