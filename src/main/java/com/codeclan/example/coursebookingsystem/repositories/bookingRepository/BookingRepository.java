package com.codeclan.example.coursebookingsystem.repositories.bookingRepository;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.projections.EmbededCourseAndCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbededCourseAndCustomer.class)
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCostum {

    List<Booking> findBookingByDate(String date);
    List<Booking> findAllByCustomerAgeBetweenAndCourseNameIsStartingWith(int minAge, int maxAge, String courseInitial);
}
