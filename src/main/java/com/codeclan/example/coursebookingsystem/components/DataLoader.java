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
        Course course1 = new Course("course1", "Edinburgh", 2);
        courseRepository.save(course1);

        Course course2 = new Course("course2", "Edinburgh", 4);
        courseRepository.save(course2);

        Course course3 = new Course("course3", "London", 4);
        courseRepository.save(course3);

        Course course4 = new Course("course4", "London", 4);
        courseRepository.save(course4);

        Customer customer1 = new Customer("Paolo", "Milano", 29);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Daniel", "Budapest", 22);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Eduardo", "Milano", 43);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Baby Eduardo", "Milano", 12);
        customerRepository.save(customer4);

        Booking booking1 = new Booking("12-23-2018", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("12-23-2020", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("12-23-2020", course2, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("12-23-2021", course4, customer3);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("12-23-2021", course4, customer4);
        bookingRepository.save(booking5);
    }
}
