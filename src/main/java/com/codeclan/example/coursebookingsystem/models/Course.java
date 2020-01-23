package com.codeclan.example.coursebookingsystem.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String towm;
    private int rating;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Course(){}

    public Course(String name, String towm, int rating) {
        this.name = name;
        this.towm = towm;
        this.rating = rating;
        this.bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTowm() {
        return towm;
    }

    public void setTowm(String towm) {
        this.towm = towm;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
