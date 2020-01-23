package com.codeclan.example.coursebookingsystem.repositories;

import com.codeclan.example.coursebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseId(long id);
    List<Customer> findCustomerByBookingsCourseIdAndTown(long id, String town);
    List<Customer> findAllByTownAndBookingsCourseIdAndAgeGreaterThan(String town, long courseId, int age);
}
