package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.ServiceModel;
import com.hotel.hotelPrak.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceModelServiceImpl implements ServiceModelService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceModel> findAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceModel findServiceById(UUID id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceModel addService(ServiceModel service) {
        return serviceRepository.save(service);
    }

    @Override
    public ServiceModel updateService(ServiceModel service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(UUID id) {
        serviceRepository.deleteById(id);
    }
}