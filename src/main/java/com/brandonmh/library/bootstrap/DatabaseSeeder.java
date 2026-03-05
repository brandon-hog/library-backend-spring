package com.brandonmh.library.bootstrap;

import com.brandonmh.library.model.Book;
import com.brandonmh.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// @Component ensures Spring Boot automatically detects and runs this class on startup.
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DatabaseSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Idempotency check: Only run the seeder if the table is completely empty.
        // This prevents duplicating your dataset every time the application restarts.
        if (bookRepository.count() == 0) {
            
            List<Book> booksToSeed = generateRandomBooks(50); // Generate 50 books
            
            // saveAll() is significantly more efficient than looping and calling save() individually.
            bookRepository.saveAll(booksToSeed);
            
            System.out.println("✅ Database successfully seeded with " + booksToSeed.size() + " books.");
        }
    }

    private List<Book> generateRandomBooks(int count) {
        List<Book> books = new ArrayList<>();
        Random random = new Random();

        String[] adjectives = {"The Quantum", "Effective", "Clean", "Advanced", "The Silent", "Dark", "Hidden", "Practical", "Modern", "Essential"};
        String[] nouns = {"Network", "Code", "Architecture", "Algorithms", "Shadow", "Systems", "Security", "Patterns", "Protocol", "Framework"};
        String[] authors = {"Alan Turing", "Grace Hopper", "Ada Lovelace", "Linus Torvalds", "Margaret Hamilton", "Ken Thompson", "Dennis Ritchie", "Tim Berners-Lee"};

        for (int i = 0; i < count; i++) {
            String randomTitle = adjectives[random.nextInt(adjectives.length)] + " " + nouns[random.nextInt(nouns.length)];
            String randomAuthor = authors[random.nextInt(authors.length)];
            
            // 80% chance the book is available, 20% chance it is already checked out
            boolean isAvailable = random.nextInt(100) < 80;

            // ID is passed as null because the @GeneratedValue strategy in the entity handles it
            books.add(new Book(null, randomTitle, randomAuthor, isAvailable));
        }

        return books;
    }
}