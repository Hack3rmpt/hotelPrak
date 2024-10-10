package com.hotel.hotelPrak.repository;


import com.hotel.hotelPrak.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, UUID> {
}
