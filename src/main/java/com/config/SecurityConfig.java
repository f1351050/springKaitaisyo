package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	/*
	@Override
	public configure(HttpSecurity web)throws Exception{
		
		web.
		  .requestMatchers("/webjars/**")
		  .requestMatchers("/css/**")
		  .requestMatchers("/js/**")
		  .requestMatchers("/h2-console/**");
		
	}
	*/
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception{
		
		http
			.authorizeHttpRequests(authz -> authz
				.requestMatchers("/css/**")
					.permitAll()
				.requestMatchers("/webjars/**")
					.permitAll()
				.requestMatchers("/js/**")
					.permitAll()
				.requestMatchers("/h2-console/**")
					.permitAll()
				.requestMatchers("/login")
					.permitAll()
				.requestMatchers("/user/signup")
					.permitAll()
				.anyRequest().authenticated()
		);
		return http.build();
		/*
		http.formLogin(login -> login         //フォーム認証の設定記述開始
				.loginProcessingUrl("/login") //ユーザー名・パスワードの送信先URL
				.loginPage("/login")          //ログイン画面のURL
				.defaultSuccessUrl("/")       //ログイン成功後のﾘﾀﾞｲﾚｸﾄ先URL
				.failureUrl("/login?error")   //ログイン失敗後のﾘﾀﾞｲﾚｸﾄ先URL
				.permitAll()                  //ログイン画面は未ログインでもアクセス可能
		);
		*/
		/*
		 .authorizeRequests()
		  .antMatchers("/login").permitAll()
		  .antMatchers("/user/signup").permitAll()
		  .antRequest().authenticated();
		  */
	    
		//http.csrf().disable();
	}
	
}
