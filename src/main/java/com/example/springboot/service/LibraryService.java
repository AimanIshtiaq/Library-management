package com.example.springboot.service;

import com.example.springboot.model.Library;
import com.example.springboot.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public void saveLibrary(Library library) {
        libraryRepository.save(library);
    }

    public Library getLibraryByEmail(String email) {
        return libraryRepository.findByEmailAddress(email);
    }

    public void updateLibrary(Library updatedLibrary) {
        Library existingLibrary = libraryRepository.findByEmailAddress(updatedLibrary.getEmailAddress());

        if (existingLibrary != null) {
            // Update profile-related fields
            existingLibrary.setFirstName(updatedLibrary.getFirstName());
            existingLibrary.setLastName(updatedLibrary.getLastName());
            existingLibrary.setProfilePictureUrl(updatedLibrary.getProfilePictureUrl());
            // Update other profile-related fields

            // Save the updated library
            libraryRepository.save(existingLibrary);
        }
        // Handle case where the library is not found
    }
}
