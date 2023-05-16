package com.example.StudentManagement.service;
import com.example.StudentManagement.model.Book;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repo.IBookRepo;
import com.example.StudentManagement.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;

    @Autowired
    IStudentRepo studentRepo;

    public String addBook(Book book) {
        if(book!=null){
            Long studentId = book.getStudent().getStudentId();
            Optional<Student> student = studentRepo.findById(studentId);
            if(student.isPresent()){
                book.setStudent(student.get());
                bookRepo.save(book);
                return "Book added sucessfully";
            }
            return "Enter valid details";

        }
        return "Book not added sucessfully";

    }

    public List<Book> getAllBook(Long bookId) {
        if(bookId==null){
            return bookRepo.findAll();
        }else{
            List<Book> bookList = new ArrayList<>();
            bookList.add(bookRepo.findById(bookId).get());
            return bookList;
        }
    }

    public String deleteBookById(Long bookId) {
        Optional<Book> optionalbook = bookRepo.findById(bookId);
        if(optionalbook.isEmpty()){
            return "Book with id "+bookId + " is not present";
        }else{
            bookRepo.deleteById(bookId);
            return "Book with id "+bookId + " deleted successfully";
        }
    }

    public String updateBook(Long bookId, Book book) {
        Optional<Book> optionalbook = bookRepo.findById(bookId);
        Student student = book.getStudent();
        if(optionalbook.isEmpty()){
            return "Book with id "+bookId + " is not present";
        }else{
            Optional<Student> student1 = studentRepo.findById(student.getStudentId());
            book.setStudent(student1.get());

            book.setBookId(bookId);
            bookRepo.save(book);
            return "Book with id "+bookId + " updated successfully";
        }
    }
}
