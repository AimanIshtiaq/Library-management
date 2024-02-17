package com.example.springboot.service;

import com.example.springboot.model.Book;
import com.example.springboot.model.Student;
import com.example.springboot.repository.BookRepository;
import com.example.springboot.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllBooks() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Transactional
    public void updateStudent(Long id, Student updatedStudent) {
        // Check if the book with the given ID exists
        Optional<Student> existingStudentOptional = studentRepository.findById(id);

        if (existingStudentOptional.isPresent()) {
            // Book with the given ID exists
            Student existingStudent = existingStudentOptional.get();

            // Update the existing book with the new information
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            // Add more fields as needed

            // Save the updated book
            studentRepository.save(existingStudent);
        }
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
