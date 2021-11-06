package com.library.management.system.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.management.system.beans.Book;

@Repository
public class LibraryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Book> getAllBooks() {

		Session session = sessionFactory.getCurrentSession();

		List<Book> bookList = session.createQuery("from Book").getResultList();

		System.out.println("Book list retrieved: " + bookList);

		return bookList;
	}

	@Transactional
	public Book getBook(String id) {

		int bookId = Integer.parseInt(id);

		Session session = sessionFactory.getCurrentSession();

		Book retrievedBook = session.get(Book.class, bookId);

		System.out.println("Book retrieved: " + retrievedBook);

		return retrievedBook;
	}

	@Transactional
	public Book addBook(Book book) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(book);

		System.out.println("Added Book successfully");

		return book;
	}

	@Transactional
	public Book deleteBook(Book book) {

		Session session = sessionFactory.getCurrentSession();

		session.delete(book);

		System.out.println("Deleted Book successfully");

		return book;
	}
}
