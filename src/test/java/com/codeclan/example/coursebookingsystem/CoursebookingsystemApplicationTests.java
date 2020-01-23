package com.codeclan.example.coursebookingsystem;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.bookingRepository.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.courseRepository.CourseRepository;
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
		assertEquals(5, courseRepository.findAll().size());

		Customer customer = new Customer("Paolo", "Milano", 29);
		customerRepository.save(customer);
		assertEquals(5, customerRepository.findAll().size());

        Booking booking = new Booking("12-23-2018", course, customer);
        bookingRepository.save(booking);
        assertEquals(6, bookingRepository.findAll().size());
	}

	@Test
    void canGetCourseByRating(){
	    List<Course> found = courseRepository.findCourseByRating(4);
	    assertEquals(3, found.size());
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

	@Test
	void canGetCustomerForGivenTownAndCourse(){
		List<Customer> found = customerRepository.findCustomerByBookingsCourseIdAndTown(2, "Milano");
		assertEquals("Eduardo", found.get(0).getName());
	}

	@Test
	void canGetCustomersForGivenTownAndCourseAndAgeGreater(){
		List<Customer> found = customerRepository.findAllByTownAndBookingsCourseIdAndAgeGreaterThan("Milano", 4, 18);
		assertEquals(1, found.size());
	}

	@Test
	void cannotGetCustomersForGivenTownAndCourseAndAgeGreater(){
		List<Customer> found = customerRepository.findAllByTownAndBookingsCourseIdAndAgeGreaterThan("Milano", 4, 50);
		assertEquals(0, found.size());
	}

	@Test
	void canGetCourseByCustomerAgeLessThan(){
		List<Course> found = courseRepository.findAllByCostumerAgeLessThen(13);
		assertEquals(1, found.size());
	}

	@Test
	void canGetBookingsByCustomerAgeBetweenAndCourseInital(){
		List<Booking> found = bookingRepository.findAllByCustomerAgeBetweenAndCourseNameStartWith(10, 14, "c");
		assertEquals("Baby Eduardo", found.get(0).getCustomer().getName());
	}

}
