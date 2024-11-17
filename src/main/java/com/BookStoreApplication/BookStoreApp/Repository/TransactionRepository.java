package com.BookStoreApplication.BookStoreApp.Repository;

import com.BookStoreApplication.BookStoreApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByRequesterId(Long requesterId);
    List<Transaction> findByBookId(Long bookId);
    // Additional custom query methods can be added here
}