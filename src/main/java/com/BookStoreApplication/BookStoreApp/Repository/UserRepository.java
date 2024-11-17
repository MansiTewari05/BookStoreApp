package com.BookStoreApplication.BookStoreApp.Repository;

import com.BookStoreApplication.BookStoreApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods (if needed) can be added here
}