package com.codeclan.example.coursebookingsystem.repositories;

import com.codeclan.example.coursebookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
