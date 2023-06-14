package br.com.unipar.Hospital.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import br.com.unipar.Hospital.Controller.UsuarioController;
import br.com.unipar.Hospital.Model.Usuario;
import br.com.unipar.Hospital.Repository.UsuarioRepository;
import br.com.unipar.Hospital.Service.UsuarioService;

@EnableWebSecurity

@EnableAuthorizationServer

@EnableResourceServer
public class Security extends WebSecurityConfigurerAdapter {
	private UsuarioRepository usuarioRepository;
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		List<Usuario> usuarios = usuarioRepository.findAll();
//		for (Usuario usuario : usuarios) {
//			auth.inMemoryAuthentication().withUser("lucas").password("123").roles("ADMIN");
//		}
		System.out.println("teste kls: " + auth.toString());
		auth.inMemoryAuthentication().withUser("lucas").password("123").roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser("kedssy").password("123").roles("ADMIN");
		System.out.println("teste kls: " + auth.toString());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return NoOpPasswordEncoder.getInstance();

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	   //web.ignoring().antMatchers("/**");
	    web.ignoring().antMatchers("/swagger-ui.html");
	    web.ignoring().antMatchers("/swagger-resources/**");
	    web.ignoring().antMatchers("/v2/**");
	    web.ignoring().antMatchers("/csrf");
	    web.ignoring().antMatchers("/webjars/springfox-swagger-ui/**");

	}
}
