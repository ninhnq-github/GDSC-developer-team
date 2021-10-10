package com.example.demo.security.config;


import com.example.demo.service.AppUserService;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AppUserService appUserService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private DataSource dataSource;
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    // Sét đặt dịch vụ để tìm kiếm User trong Database.
    // Và sét đặt PasswordEncoder.
    auth.userDetailsService(appUserService).passwordEncoder(bCryptPasswordEncoder);

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();

//    http.authorizeRequests().anyRequest().permitAll();

    http.authorizeRequests().and().formLogin()//
        // Submit URL của trang login
        .loginProcessingUrl("/j_spring_security_check") // Submit URL
        .loginPage("/login")//
        .defaultSuccessUrl("/dayne")//
        .failureUrl("/login?error=true")//
        .usernameParameter("username")//
        .passwordParameter("password");
    // Cấu hình Remember Me.
//    http.authorizeRequests().and() //
//        .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//        .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h


    http.authorizeRequests()
        .antMatchers("/**","static/**").permitAll()
        .antMatchers("/registration")
        .permitAll()
        .antMatchers("/login")
        .permitAll()
        .antMatchers("/")
        .permitAll()
        .antMatchers("/index")
        .hasAuthority("USER")
        .antMatchers("/admin")
        .hasAuthority("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider provider =
        new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(appUserService);
    return provider;
  }

  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
    db.setDataSource(dataSource);
    return db;
  }
}
