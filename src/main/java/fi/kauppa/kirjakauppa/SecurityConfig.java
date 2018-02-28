package fi.kauppa.kirjakauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import fi.kauppa.kirjakauppa.beans.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Override
	protected void configure(HttpSecurity sec) throws Exception {
		sec
		.authorizeRequests().antMatchers("/css/**").permitAll()
		.and()
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/booklist")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(new 
				BCryptPasswordEncoder());
		
		
		
//		auth.inMemoryAuthentication()
//			.withUser("juicer").password("passu").roles("USER").and()
//			.withUser("admin").password("password").roles("USER", "ADMIN");
//		
		
	}
}
