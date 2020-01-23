package com.codeclan.example.coursebookingsystem.components;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BookingRepository bookingRepository;
    private CourseRepository courseRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public DataLoader(BookingRepository bookingRepository, CourseRepository courseRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.courseRepository = courseRepository;
        this.customerRepository = customerRepository;
    }

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Course course = new Course("course1", "Edinburgh", 2);
        courseRepository.save(course);

        Customer customer = new Customer("Paolo", "Milano", 29);
        customerRepository.save(customer);

        Booking booking = new Booking("12-23-2018", course, customer);
        bookingRepository.save(booking);
    }
}
