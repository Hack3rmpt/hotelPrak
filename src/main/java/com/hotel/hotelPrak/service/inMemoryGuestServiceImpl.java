package com.hotel.hotelPrak.service;


import com.hotel.hotelPrak.model.GuestModel;
import com.hotel.hotelPrak.repository.GuestRepository;
import com.hotel.hotelPrak.repository.inMemoryGuestRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class inMemoryGuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;

    public  inMemoryGuestServiceImpl(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }


    @Override
    public List<GuestModel> findAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public GuestModel findGuestById(long id) {
        return guestRepository.findById(id).orElse(null);
    }


    @Override
    public GuestModel addGuest(GuestModel Guests) {
        return guestRepository.save(Guests);
    }

    @Override
    public GuestModel updateGuest(GuestModel Guests) {
        if(guestRepository.existsById(Guests.getId())){
            return guestRepository.save(Guests);
        }
        return null;
    }

    @Override
    public void deleteGuest(long id) {
        if (guestRepository.existsById(id)){
            guestRepository.deleteById(id);
        }
    }

    @Override
    public void softDeleteGuest(long id) {

    }


    @Override
    public List<GuestModel> findGuestByFirstNameAndLastName(String firstName, String lastName) {
        return guestRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<GuestModel> findGuestByFirstName(String firstName) {
        return guestRepository.findByFirstName(firstName);
    }

    @Override
    public List<GuestModel> findGuestByLastName(String lastName) {
        return guestRepository.findByLastName(lastName);
    }

//    @Override
//    public void softDeleteGuest(int id) {
//        guestRepository.softDeleteGuest(id);  // Логическое удаление
//    }

//    @Override
//    public List<GuestModel> findGuestByNameAndLastName(String firstName, String lastName) {
//        return guestRepository.findAllGuests().stream()
//                .filter(guest -> guest.getFirstName().equalsIgnoreCase(firstName) && guest.getLastName().equalsIgnoreCase(lastName))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<GuestModel> findGuestByFirstName(String firstName) {
//        return guestRepository.findAllGuests().stream()
//                .filter(guest -> guest.getFirstName().equalsIgnoreCase(firstName))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<GuestModel> findGuestByLastName(String lastName) {
//        return guestRepository.findAllGuests().stream()
//                .filter(guest -> guest.getLastName().equalsIgnoreCase(lastName))
//                .collect(Collectors.toList());
//    }
}
