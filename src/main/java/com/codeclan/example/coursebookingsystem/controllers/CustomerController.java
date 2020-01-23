package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/courses/{courseId}")
    public List<Customer> getAllCustomersByCourse(@PathVariable long courseId){
        return customerRepository.findCustomersByBookingsCourseId(courseId);
    }

    @GetMapping(value = "/town/{town}/course/{courseId}")
    public List<Customer> getAllCustomersByTownAndCourse(@PathVariable String town, @PathVariable long courseId){
        return customerRepository.findCustomerByBookingsCourseIdAndTown(courseId, town);
    }

    @GetMapping(value = "/town/{town}/course/{courseId}/ageGreater/{age}")
    public List<Customer> getAllCustomersForGivenTownAndCourseAndAgeGreater
            (@PathVariable String town, @PathVariable long courseId, @PathVariable int age){
        return customerRepository.findAllByTownAndBookingsCourseIdAndAgeGreaterThan(town, courseId, age);
    }
}
