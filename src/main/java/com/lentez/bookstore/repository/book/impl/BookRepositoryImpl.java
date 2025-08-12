package com.lentez.bookstore.repository.book.impl;

import com.lentez.bookstore.exception.DatabaseOperationException;
import com.lentez.bookstore.model.Book;
import com.lentez.bookstore.repository.book.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(book);
            transaction = session.getTransaction();
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DatabaseOperationException("Unable to save book", e);
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            books = session.createQuery("from Book").list();
        } catch (Exception e) {
            throw new DatabaseOperationException("Unable to find all books", e);
        }
        return books;
    }
}
