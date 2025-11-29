package com.brandonmh.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Checkout {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    private Date checkoutDate;
    private Date returnDate;

    public Checkout() {
    }

    public Checkout(Long id, Book book, User user, Date checkoutDate, Date returnDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
