package com.tutorialseu.repository;

import com.tutorialseu.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // This interface will provide built-in methods like save(), findAll(), findById(), etc.
}