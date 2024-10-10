package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.BedTypeModel;

import java.util.List;
import java.util.UUID;

public interface BedTypeService {

    List<BedTypeModel> findAllBedTypes();

    BedTypeModel findBedTypeById(UUID id);

    BedTypeModel addBedType(BedTypeModel bedType);

    BedTypeModel updateBedType(BedTypeModel bedType);

    void deleteBedType(UUID id);

}