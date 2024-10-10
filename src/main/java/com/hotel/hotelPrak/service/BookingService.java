package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.BookingModel;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    List<BookingModel> findAllBookings();

    BookingModel findBookingById(UUID id);

    BookingModel addBooking(BookingModel booking);

    BookingModel updateBooking(BookingModel booking);

    void deleteBooking(UUID id);

}