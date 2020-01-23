package com.codeclan.example.coursebookingsystem;

import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingsystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canCreateCourse(){
		Course course = new Course("course1", "Edinburgh", 2);
		courseRepository.save(course);
		assertEquals(1, courseRepository.findAll().size());
	}

}
