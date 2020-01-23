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

import java.util.List;

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
		assertEquals(4, courseRepository.findAll().size());

		Customer customer = new Customer("Paolo", "Milano", 29);
		customerRepository.save(customer);
		assertEquals(4, customerRepository.findAll().size());

        Booking booking = new Booking("12-23-2018", course, customer);
        bookingRepository.save(booking);
        assertEquals(4, bookingRepository.findAll().size());
	}

	@Test
    void canGetCourseByRating(){
	    List<Course> found = courseRepository.findCourseByRating(4);
	    assertEquals(2, found.size());
    }

    @Test
	void canGetCustomersByCourse(){
		List<Customer> found = customerRepository.findCustomersByBookingsCourseId(1L);
		assertEquals(2, found.size());
	}

	@Test
	void canGetAllCourseByCustomer(){
		List<Course> found = courseRepository.findCoursesByBookingsCustomerId(1L);
		assertEquals(1, found.size());
	}

	@Test
	void canGetBookingsByDate(){
		List<Booking> found = bookingRepository.findBookingByDate("12-23-2020");
		assertEquals(2, found.size());
	}

}
