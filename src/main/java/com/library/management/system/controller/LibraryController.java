package com.library.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.management.system.beans.Book;
import com.library.management.system.dao.LibraryDAO;

@Controller
public class LibraryController {

	@Autowired
	private LibraryDAO libraryDAO;

	@GetMapping("/")
	public String getBooks(Model model) {
		List<Book> bookList = libraryDAO.getAllBooks();
		model.addAttribute("books", bookList);
		System.out.println("Got the book list: " + bookList);
		return "lib-home";
	}

	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "book-add";
	}

	@GetMapping("/showFormForUpdate")
	public String showUpdateForm(@RequestParam("bookId") String bookId, Model model) {
		Book book = libraryDAO.getBook(bookId);
		model.addAttribute("book", book);
		System.out.println("Populating the for update: " + book);
		return "book-add";
	}

	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute Book book) {
		Book savedBook = libraryDAO.addBook(book);
		System.out.println("Successfully saved the book: " + savedBook);
		return "redirect:/";
	}

	@PutMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book) {
		System.out.println("In update Book" + book);
		Book savedBook = libraryDAO.addBook(book);
		System.out.println("Successfully updated the book: " + savedBook);
		return "redirect:/";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") String bookId) {
		Book book = libraryDAO.getBook(bookId);
		Book savedBook = libraryDAO.deleteBook(book);
		System.out.println("Successfully deleted the book: " + savedBook);
		return "redirect:/";
	}

}
