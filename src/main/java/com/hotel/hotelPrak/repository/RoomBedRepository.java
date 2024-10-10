package com.hotel.hotelPrak.repository;

import com.hotel.hotelPrak.model.RoomBedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomBedRepository extends JpaRepository<RoomBedModel, UUID> {
}
