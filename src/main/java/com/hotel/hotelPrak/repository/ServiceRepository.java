package com.hotel.hotelPrak.repository;

import com.hotel.hotelPrak.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ServiceRepository extends JpaRepository<ServiceModel, UUID> {
}
