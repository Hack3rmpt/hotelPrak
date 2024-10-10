package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.BedTypeModel;
import com.hotel.hotelPrak.repository.BedTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BedTypeServiceImpl implements BedTypeService {

    @Autowired
    private BedTypeRepository bedTypeRepository;

    @Override
    public List<BedTypeModel> findAllBedTypes() {
        return bedTypeRepository.findAll();
    }

    @Override
    public BedTypeModel findBedTypeById(UUID id) {
        return bedTypeRepository.findById(id).orElse(null);
    }

    @Override
    public BedTypeModel addBedType(BedTypeModel bedType) {
        return bedTypeRepository.save(bedType);
    }

    @Override
    public BedTypeModel updateBedType(BedTypeModel bedType) {
        return bedTypeRepository.save(bedType);
    }

    @Override
    public void deleteBedType(UUID id) {
        bedTypeRepository.deleteById(id);
    }
}