package fi.kauppa.kirjakauppa.beans;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String name);
}
