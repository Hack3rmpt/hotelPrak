package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.ServiceModel;

import java.util.List;
import java.util.UUID;

public interface ServiceModelService {

    List<ServiceModel> findAllServices();

    ServiceModel findServiceById(UUID id);

    ServiceModel addService(ServiceModel service);

    ServiceModel updateService(ServiceModel service);

    void deleteService(UUID id);

}