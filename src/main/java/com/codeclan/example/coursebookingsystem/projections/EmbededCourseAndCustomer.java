package com.codeclan.example.coursebookingsystem.projections;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "courseAndCustomer", types = Booking.class)
public interface EmbededCourseAndCustomer {


    String getDate();
    Customer getCustomer();
    Course getCourse();
}
