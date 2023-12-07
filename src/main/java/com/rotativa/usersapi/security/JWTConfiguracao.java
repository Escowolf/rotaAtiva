package com.rotativa.usersapi.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.rotativa.usersapi.services.DetalheAdminServiceImpl;

@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

  private final DetalheAdminServiceImpl administradorService;
  private final PasswordEncoder passwordEncoder;

  public JWTConfiguracao(DetalheAdminServiceImpl administradorService, PasswordEncoder passwordEncoder) {
    this.administradorService = administradorService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(administradorService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers(HttpMethod.POST, "/perfil/login").permitAll()
        .antMatchers(HttpMethod.POST, "/auth/admin/*").hasAnyAuthority("ADMIN")
        .antMatchers(HttpMethod.POST, "/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/transacao/auth/user/*").permitAll()
        .antMatchers(HttpMethod.POST, "/transacao/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/zona/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/zona/auth/user/vagas").permitAll()
        .antMatchers(HttpMethod.GET, "/perfil/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/perfil/auth/user/relatoriovaga/*").permitAll()
        .antMatchers(HttpMethod.POST, "/perfil/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/veiculo/auth/user/*").permitAll()
        .antMatchers(HttpMethod.POST, "/veiculo/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/pagamentos/auth/user/*").permitAll()
        .antMatchers(HttpMethod.POST, "/pagamentos/auth/user/*").permitAll()
        .antMatchers(HttpMethod.GET, "/tipopagamento/auth/user/*").permitAll()
        .antMatchers(HttpMethod.POST, "/tipopagamento/auth/user/*").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JWTAutenticarFilter(authenticationManager()))
        .addFilter(new JWTValidarFilter(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE"));
    source.registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }

}
