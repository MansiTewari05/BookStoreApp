package com.BookStoreApplication.BookStoreApp.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exchange_requests")
public class ExchangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String status;

    // Constructors
    public ExchangeRequest() {}

    public ExchangeRequest(User requester, Book book, String status) {
        this.requester = requester;
        this.book = book;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRequest that = (ExchangeRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(requester, that.requester) &&
                Objects.equals(book, that.book) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requester, book, status);
    }

    // Override toString
    @Override
    public String toString() {
        return "ExchangeRequest{" +
                "id=" + id +
                ", requester=" + requester +
                ", book=" + book +
                ", status='" + status + '\'' +
                '}';
    }
}