package fi.kauppa.kirjakauppa.beans;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable=false, updatable=false)
	private Long id;
	
	@Column(name = "username", nullable=false)
	private String username;
	
	@Column(name = "password", nullable=false)
	private String passwordHash;
	
	@Column(name = "email", nullable=true)
	private String email;
	
	@Column(name = "role", nullable=false)
	private String role;
	
	public User() {}
	
	public User(String username, String role, String pwdHash) {
		this.username = username;
		this.role = role;
		this.passwordHash = pwdHash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", email=" + email
				+ ", role=" + role + "]";
	}
	
	
	
}
