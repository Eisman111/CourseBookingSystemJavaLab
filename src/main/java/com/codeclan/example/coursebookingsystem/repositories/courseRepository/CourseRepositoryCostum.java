package com.codeclan.example.coursebookingsystem.repositories.courseRepository;

import com.codeclan.example.coursebookingsystem.models.Course;

import java.util.List;

public interface CourseRepositoryCostum {

    List<Course> findAllByCostumerAgeLessThen(int age);
}
