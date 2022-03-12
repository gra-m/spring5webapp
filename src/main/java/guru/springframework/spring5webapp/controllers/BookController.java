package guru.springframework.spring5webapp.controllers;

import fun.madeby.spring5WebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Because this is a springBean now..
public class BookController {

	//.. Spring will instantiate the instance of BookRepository that we need.
	private final BookRepository bookRepository;


	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model){
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}
}
