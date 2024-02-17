package com.example.springboot.repository;

import com.example.springboot.model.Library;
import com.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
    Library findByEmailAddress(String emailAddress);
}
