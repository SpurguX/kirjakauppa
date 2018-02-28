package fi.kauppa.kirjakauppa.beans;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	
	List<Genre> findByGenrename(String name);
}
