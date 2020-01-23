package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.repositories.bookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping(value = "/date/{date}")
    public List<Booking> getAllBookingsForDate(@PathVariable String date){
        return bookingRepository.findBookingByDate(date);
    }
}
