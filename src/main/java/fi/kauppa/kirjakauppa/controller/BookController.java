package fi.kauppa.kirjakauppa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.kauppa.kirjakauppa.beans.BookRepository;

@Controller

public class BookController {
	
	@Autowired
	private BookRepository repo;
	
	@RequestMapping("*") 
	public String index() {
		return "booklist";
	}
	
	@RequestMapping(value = "/booklist", method=RequestMethod.GET)
	public String showBooklist(Model model) {
		model.addAttribute("booklist", repo.findAll());
		return "booklist";
	}
}
