package com.BookStoreApplication.BookStoreApp.service;

import com.BookStoreApplication.BookStoreApp.Repository.ExchangeRequestRepository;
import com.BookStoreApplication.BookStoreApp.model.ExchangeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRequestService {

    @Autowired
    private ExchangeRequestRepository exchangeRequestRepository;

    public List<ExchangeRequest> getAllExchangeRequests() {
        return exchangeRequestRepository.findAll();
    }

    public Optional<ExchangeRequest> getExchangeRequestById(Long id) {
        return exchangeRequestRepository.findById(id);
    }

    public ExchangeRequest createExchangeRequest(ExchangeRequest exchangeRequest) {
        return exchangeRequestRepository.save(exchangeRequest);
    }

    public ExchangeRequest updateExchangeRequest(Long id, ExchangeRequest exchangeRequestDetails) {
        Optional<ExchangeRequest> exchangeRequestOptional = exchangeRequestRepository.findById(id);
        if (exchangeRequestOptional.isPresent()) {
            ExchangeRequest exchangeRequest = exchangeRequestOptional.get();
            exchangeRequest.setRequester(exchangeRequestDetails.getRequester());
            exchangeRequest.setBook(exchangeRequestDetails.getBook());
            exchangeRequest.setStatus(exchangeRequestDetails.getStatus());
            return exchangeRequestRepository.save(exchangeRequest);
        } else {
            throw new RuntimeException("ExchangeRequest not found with id " + id);
        }
    }

    public void deleteExchangeRequest(Long id) {
        exchangeRequestRepository.deleteById(id);
    }

    public List<ExchangeRequest> getExchangeRequestsByRequesterId(Long requesterId) {
        return exchangeRequestRepository.findByRequesterId(requesterId);
    }

    public List<ExchangeRequest> getExchangeRequestsByBookId(Long bookId) {
        return exchangeRequestRepository.findByBookId(bookId);
    }
}
