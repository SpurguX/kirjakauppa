package fi.kauppa.kirjakauppa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.kauppa.kirjakauppa.beans.Book;
import fi.kauppa.kirjakauppa.beans.BookRepository;
import fi.kauppa.kirjakauppa.beans.GenreRepository;

@Controller

public class BookController {
	
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private GenreRepository genreRepo;

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/booklist", method=RequestMethod.GET)
	public String showBooklist(Model model) {
		model.addAttribute("booklist", repo.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/addbook", method=RequestMethod.GET)
	public String toAddBookPage(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("genres", genreRepo.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method=RequestMethod.POST)
	public String addBook(Book book) {
		repo.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/deleteBook/{id}", method=RequestMethod.POST)
	public String deleteBook(@PathVariable("id") Long id, Book book) {
		repo.delete(book);
		return "redirect:../booklist";
	}
	
	//JSON
	
	@ResponseBody
	@RequestMapping(value = "/booklistJson", method=RequestMethod.GET)
	public List<Book> booklistJson() {
		return (List<Book>) repo.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/bookJson/{id}", method=RequestMethod.GET)
	public Book bookJsonById(@PathVariable("id") Long id) {
		return repo.findOne(id);
	}
	
	
}
