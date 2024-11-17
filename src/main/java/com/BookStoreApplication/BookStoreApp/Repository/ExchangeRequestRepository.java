package com.BookStoreApplication.BookStoreApp.Repository;

import com.BookStoreApplication.BookStoreApp.model.ExchangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Long> {
    List<ExchangeRequest> findByRequesterId(Long requesterId);
    List<ExchangeRequest> findByBookId(Long bookId);
    // Additional custom query methods can be added here
}