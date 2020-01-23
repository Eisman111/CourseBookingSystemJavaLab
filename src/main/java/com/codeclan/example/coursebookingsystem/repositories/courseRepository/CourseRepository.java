package com.codeclan.example.coursebookingsystem.repositories.courseRepository;

import com.codeclan.example.coursebookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCostum {

    List<Course> findCourseByRating(int rating);
    List<Course> findCoursesByBookingsCustomerId(long id);
    List<Course> findAllByCostumerAgeLessThen(int age);
}
