package com.example.springboot.service;

import com.example.springboot.model.Book;
import com.example.springboot.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Transactional
    public void updateBook(Long id, Book updatedBook) {
        // Check if the book with the given ID exists
        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (existingBookOptional.isPresent()) {
            // Book with the given ID exists
            Book existingBook = existingBookOptional.get();

            // Update the existing book with the new information
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            // Add za\more fields as needed

            // Save the updated book
            bookRepository.save(existingBook);
        }
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
