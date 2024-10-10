package com.hotel.hotelPrak.service;

import com.hotel.hotelPrak.model.BookingModel;
import com.hotel.hotelPrak.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<BookingModel> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingModel findBookingById(UUID id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public BookingModel addBooking(BookingModel booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public BookingModel updateBooking(BookingModel booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(UUID id) {
        bookingRepository.deleteById(id);
    }
}