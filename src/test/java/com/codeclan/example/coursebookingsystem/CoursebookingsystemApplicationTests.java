package com.codeclan.example.coursebookingsystem;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingsystemApplicationTests {

	private CourseRepository courseRepository;
	private BookingRepository bookingRepository;

	@Autowired
	public CoursebookingsystemApplicationTests(CourseRepository courseRepository, BookingRepository bookingRepository) {
		this.courseRepository = courseRepository;
		this.bookingRepository = bookingRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void canCreateCourseAndBooking(){
		Course course = new Course("course1", "Edinburgh", 2);
		courseRepository.save(course);
		assertEquals(1, courseRepository.findAll().size());

		Booking booking = new Booking("12-23-2018");
		bookingRepository.save(booking);
		assertEquals(1, bookingRepository.findAll().size());
	}

}
