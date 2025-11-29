package com.brandonmh.library.service;

import com.brandonmh.library.model.Book;
import com.brandonmh.library.model.Checkout;
import com.brandonmh.library.model.User;
import com.brandonmh.library.repository.CheckoutRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    private final CheckoutRepository checkoutRepo;

    public CheckoutService(CheckoutRepository checkoutRepo) {
        this.checkoutRepo = checkoutRepo;
    }

    public Checkout checkoutBook(Book bookId, User userId) {
        Checkout checkout = new Checkout();

        checkout.setBook(bookId);
        checkout.setUser(userId);
        checkout.setCheckoutDate(new Date());

        return checkoutRepo.save(checkout);
    }

    public Checkout returnBook(Long bookId, Long userId) throws Exception {
        List<Checkout> checkout = checkoutRepo.findByBook_IdAndUser_IdAndReturnDateIsNull(bookId, userId);

        if (checkout.isEmpty()) {
            throw new Exception("No checkout records for book and user.");
        }

        checkout.get(0).setReturnDate(new Date());
        return checkoutRepo.save(checkout.get(0));
    }

    public List<Checkout> getAllCheckouts() {
        return checkoutRepo.findAll();
    }

    public Optional<Checkout> getCheckoutById(Long id) {
        return checkoutRepo.findById(id);
    }
}
