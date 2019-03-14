package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Book;
import com.cts.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bs;

	@GetMapping("/list")
	public String listAllBooks(Model model) {

		
		System.out.println("Entered in  list abook");
		List<Book> lb = bs.listallBooks();
		model.addAttribute("books", lb);

		return "bookList";
	}
	@GetMapping("/showForm")
	public String showAddBook(Model model) {

		
		System.out.println("Entered in  list abook");
		Book theBook = new Book();
		
		model.addAttribute("book", theBook);

		return "addBook";
	}
	
	
	@PostMapping("/saveBook")
	public String saveABook(@ModelAttribute("book") Book theBook)
	{
		System.out.println("Hey Save Book" + theBook);
		bs.saveBook(theBook);
		return "redirect:/book/list";
		
		
	}
	
	@GetMapping("/updateForm")
	public  String showFormUpdate(@RequestParam("bookId") int theId,Model theModel)
	{
		System.out.println("UPDATE FORM THE ID"+ theId);
		Book  book =bs.getBook(theId);
		theModel.addAttribute("book",book);
		return "addBook";
		
	}
	
	
	@GetMapping("/deleteForm")
	public String deleteBook(@RequestParam("bookId") int Id)
	{System.out.println("delete book");
		bs.deleteBook(Id);
		return "redirect:/book/list";
	}
	
}
