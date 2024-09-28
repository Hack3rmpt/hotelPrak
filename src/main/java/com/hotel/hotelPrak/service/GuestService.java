package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.GuestModel;

import java.util.List;

public interface GuestService {
    List<GuestModel> findAllGuests();
    GuestModel findGuestById(long id);
    GuestModel addGuest(GuestModel guest);
    GuestModel updateGuest(GuestModel guest);
    void deleteGuest(long id);
    void softDeleteGuest(long id);
    List<GuestModel> findGuestByFirstNameAndLastName(String firstName, String lastName);
    List<GuestModel> findGuestByFirstName(String firstName);
    List<GuestModel> findGuestByLastName(String lastName);





//    List<GuestModel> findGuestByNameAndLastName(String firstName, String lastName);
//
//    List<GuestModel> findGuestByFirstName(String firstName);
//
//    List<GuestModel> findGuestByLastName(String lastName);


    }


