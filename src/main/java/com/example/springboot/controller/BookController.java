package com.example.springboot.controller;

import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/book_issue")
    public String showbookissue()
    {
        return "issueBook";
    }

    @GetMapping("/addbook")
    public String showaddbook(Model model) {
        model.addAttribute("book",new Book());
        return "addbook";
    }
    @PostMapping("/addbook")
    public String processaddbook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/viewbook";
    }

    @GetMapping("/updatebook/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "updatebook";
    }

    @PostMapping("/updatebook/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        bookService.updateBook(id, book);
        return "redirect:/viewbook";
    }


    @GetMapping("/deletebook/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "deletebook";
    }

    @PostMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/viewbook";
    }

    @GetMapping("/viewbook")
    public String showviewbook(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "viewbook";
    }
}
