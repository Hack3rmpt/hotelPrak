package com.hotel.hotelPrak.repository;


import com.hotel.hotelPrak.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomModel, Long> {
}
