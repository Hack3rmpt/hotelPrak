package com.hotel.hotelPrak.repository;

import com.hotel.hotelPrak.model.GuestModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class inMemoryGuestRepository {
//    private List<GuestModel> Guests = new ArrayList<>();
//    private AtomicInteger idCounter = new AtomicInteger(1);
//
//    public List<GuestModel> findAllGuests() {
//        return Guests.stream()
//                .filter(guest -> !guest.isDeleted()) // фильтруем удаленных
//                .collect(Collectors.toList());
//    }
//    public GuestModel addGuest(GuestModel guest){
//        guest.setId(idCounter. getAndIncrement());
//        Guests.add(guest);
//        return guest;
//    }
//    public GuestModel updateGuest(GuestModel guest){
//        for (int i = 0; i < Guests.size(); i++){
//            if(Guests.get(i). getId() == guest.getId()){
//                Guests.set(i, guest);
//                return guest;
//            }
//        }
//        return null;
//    }
//    public void deleteGuest(int id){
//        Guests.removeIf(guest -> guest.getId() == id);
//    }
//
//    public void softDeleteGuest(int id) {
//        for (GuestModel guest : Guests) {
//            if (guest.getId() == id) {
//                guest.setDeleted(true);
//                break;
//            }
//        }
//    }
//
//    public GuestModel findGuestById(int id){
//        return Guests.stream().filter(guest -> guest.getId() == id). findFirst().orElse(null);
//    }
}
