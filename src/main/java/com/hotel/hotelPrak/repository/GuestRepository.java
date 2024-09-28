package com.hotel.hotelPrak.repository;

import com.hotel.hotelPrak.model.GuestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GuestRepository extends JpaRepository<GuestModel, Long> {
    List<GuestModel> findByFirstNameAndLastName(String firstName, String lastName);
    List<GuestModel> findByFirstName(String firstName);
    List<GuestModel> findByLastName(String lastName);
}
