package com.codeclan.example.coursebookingsystem.repositories.bookingRepository;

import com.codeclan.example.coursebookingsystem.models.Booking;

import java.util.List;

public interface BookingRepositoryCostum {

    List<Booking> findAllByCustomerAgeBetweenAndCourseNameStartWith(int minAge, int maxAge, String nameInitial);
}
