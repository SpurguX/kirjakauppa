package fi.kauppa.kirjakauppa.beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long genreId;
	private String genrename;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "genre")
	private List<Book> books;
	
	
	public Genre() {}

	public Genre(String genrename) {
		super();
		this.genrename = genrename;
	}
	
	public Long getGenreId() {
		return genreId;
	}


	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}


	public String getGenrename() {
		return genrename;
	}


	public void setGenrename(String genreName) {
		this.genrename = genreName;
	}


	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genrename=" + genrename + "]";
	}
	
	
	
}
