package com.codeclan.example.coursebookingsystem.repositories.courseRepository;

import com.codeclan.example.coursebookingsystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryCostumImpl implements CourseRepositoryCostum {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Course> findAllByCostumerAgeLessThen(int age) {
        List<Course> courses = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Course.class);
        criteria.createAlias("bookings", "booking");
        criteria.createAlias("booking.customer", "customer");
        criteria.add(Restrictions.lt("customer.age", age));
        courses = criteria.list();
        return courses;
    }
}
