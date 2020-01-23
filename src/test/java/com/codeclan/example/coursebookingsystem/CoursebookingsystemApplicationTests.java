package com.codeclan.example.coursebookingsystem;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingsystemApplicationTests {

	private CourseRepository courseRepository;
	private BookingRepository bookingRepository;
	private CustomerRepository customerRepository;

	@Autowired
    public CoursebookingsystemApplicationTests(CourseRepository courseRepository, BookingRepository bookingRepository, CustomerRepository customerRepository) {
        this.courseRepository = courseRepository;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
    }

    @Test
	void contextLoads() {
	}

	@Test
	void canCreateCourseAndBooking(){
		Course course = new Course("course1", "Edinburgh", 2);
		courseRepository.save(course);
		assertEquals(1, courseRepository.findAll().size());

		Customer customer = new Customer("Paolo", "Milano", 29);
		customerRepository.save(customer);
		assertEquals(1, customerRepository.findAll().size());

        Booking booking = new Booking("12-23-2018", course, customer);
        bookingRepository.save(booking);
        assertEquals(1, bookingRepository.findAll().size());
	}

}
