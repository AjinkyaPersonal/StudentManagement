package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Book;
import com.example.StudentManagement.service.BookService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookConroller {

    @Autowired
    BookService bookService;

    @PostMapping()
    public String addBook(@RequestBody Book book){

        return bookService.addBook(book);
    }

    @GetMapping()
    public List<Book> getAllBook(@Nullable @RequestParam Long bookId){
        return bookService.getAllBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public String deleteBookById(@PathVariable Long bookId){
        return bookService.deleteBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public String updateBook(@PathVariable Long bookId , @RequestBody Book book){
        return bookService.updateBook(bookId , book);
    }
}
