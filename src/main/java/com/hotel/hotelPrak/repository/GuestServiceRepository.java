package com.hotel.hotelPrak.repository;


import com.hotel.hotelPrak.model.GuestServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface GuestServiceRepository extends JpaRepository<GuestServiceModel, UUID> {
}
