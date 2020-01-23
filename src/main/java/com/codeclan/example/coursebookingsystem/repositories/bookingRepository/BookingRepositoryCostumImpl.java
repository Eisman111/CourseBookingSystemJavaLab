package com.codeclan.example.coursebookingsystem.repositories.bookingRepository;

import com.codeclan.example.coursebookingsystem.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class BookingRepositoryCostumImpl implements BookingRepositoryCostum {

    private EntityManager entityManager;

    @Autowired
    public BookingRepositoryCostumImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Booking> findAllByCustomerAgeBetweenAndCourseNameStartWith(int minAge, int maxAge, String nameInitial) {
        List<Booking> bookings = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Booking.class);
        criteria.createAlias("customer", "customer");
        criteria.add(Restrictions.between("customer.age", minAge, maxAge));
        criteria.createAlias("course", "course");
        criteria.add(Restrictions.ilike("course.name", nameInitial, MatchMode.START));
        bookings = criteria.list();
        return bookings;
    }
}
