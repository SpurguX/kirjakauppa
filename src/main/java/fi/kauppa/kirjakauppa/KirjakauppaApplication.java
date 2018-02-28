package fi.kauppa.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.kauppa.kirjakauppa.beans.Book;
import fi.kauppa.kirjakauppa.beans.BookRepository;
import fi.kauppa.kirjakauppa.beans.Genre;
import fi.kauppa.kirjakauppa.beans.GenreRepository;
import fi.kauppa.kirjakauppa.beans.User;
import fi.kauppa.kirjakauppa.beans.UserRepository;

@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner KirjakauppaRunner(BookRepository bookrepo, GenreRepository genrerepo, UserRepository userrepo) {
		return (args) -> {
			log.info("Adding genres...");
			genrerepo.save(new Genre("Kauhu"));
			genrerepo.save(new Genre("Jännitys"));
			genrerepo.save(new Genre("Romantiikka"));
			genrerepo.save(new Genre("Scifi"));
			
			log.info("Adding books...");
			bookrepo.save(new Book("Kova kirja", "Kova Kirjailija", "fgdf-12323", 2011, 8.99, genrerepo.findByGenrename("Scifi").get(0)));
			bookrepo.save(new Book("Jeejeejuu", "Jamppa J.", "asdf-2323", 2013, 9.99, genrerepo.findByGenrename("Romantiikka").get(0)));
			bookrepo.save(new Book("Pamputuksen hinta", "Ritva Ankka", "uju-12323", 2009, 7.99, genrerepo.findByGenrename("Jännitys").get(0)));
			
			log.info("Adding users...");
			User juice = new User("juice", "USER", "$2a$10$M2mLks07HjeMD7as/083z.SrudHXuT9xkT8uncAjjViKHyMP44Nku");
			System.out.println(juice);
			userrepo.save(juice); // leskinen
			User admin = new User("admin", "ADMIN", "$2a$10$kFjuRoi2oRsJ1qHKAZXNsOLYk2ZJmlkuXTT7F1lfuKikqMbJHk4Qa");
			userrepo.save(admin); // secret
			log.info("Fetching users...");
			for (User u : userrepo.findAll()) {
				log.info(u.toString());
			}
			
			log.info("Fetching books...");
			for (Book b : bookrepo.findAll()) {
				log.info(b.toString());
			}
		};
	}
}
