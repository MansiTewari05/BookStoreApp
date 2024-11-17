package com.BookStoreApplication.BookStoreApp.controller;

import com.BookStoreApplication.BookStoreApp.model.ExchangeRequest;
import com.BookStoreApplication.BookStoreApp.service.ExchangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeRequestController {

    @Autowired
    private ExchangeRequestService exchangeRequestService;

    @GetMapping
    public List<ExchangeRequest> getAllExchangeRequests() {
        return exchangeRequestService.getAllExchangeRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeRequest> getExchangeRequestById(@PathVariable Long id) {
        Optional<ExchangeRequest> exchangeRequest = exchangeRequestService.getExchangeRequestById(id);
        return exchangeRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ExchangeRequest createExchangeRequest(@RequestBody ExchangeRequest exchangeRequest) {
        return exchangeRequestService.createExchangeRequest(exchangeRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExchangeRequest> updateExchangeRequest(@PathVariable Long id, @RequestBody ExchangeRequest exchangeRequestDetails) {
        try {
            ExchangeRequest updatedExchangeRequest = exchangeRequestService.updateExchangeRequest(id, exchangeRequestDetails);
            return ResponseEntity.ok(updatedExchangeRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExchangeRequest(@PathVariable Long id) {
        exchangeRequestService.deleteExchangeRequest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/requester/{requesterId}")
    public List<ExchangeRequest> getExchangeRequestsByRequesterId(@PathVariable Long requesterId) {
        return exchangeRequestService.getExchangeRequestsByRequesterId(requesterId);
    }

    @GetMapping("/book/{bookId}")
    public List<ExchangeRequest> getExchangeRequestsByBookId(@PathVariable Long bookId) {
        return exchangeRequestService.getExchangeRequestsByBookId(bookId);
    }
}