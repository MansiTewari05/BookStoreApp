package com.BookStoreApplication.BookStoreApp.service;

import com.BookStoreApplication.BookStoreApp.model.Transaction;
import com.BookStoreApplication.BookStoreApp.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            transaction.setRequester(transactionDetails.getRequester());
            transaction.setBook(transactionDetails.getBook());
            transaction.setTransactionDate(transactionDetails.getTransactionDate());
            transaction.setStatus(transactionDetails.getStatus());
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found with id " + id);
        }
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionsByRequesterId(Long requesterId) {
        return transactionRepository.findByRequesterId(requesterId);
    }

    public List<Transaction> getTransactionsByBookId(Long bookId) {
        return transactionRepository.findByBookId(bookId);
    }
}
