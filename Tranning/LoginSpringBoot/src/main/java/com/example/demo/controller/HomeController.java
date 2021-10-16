package com.example.demo.controller;


import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

  @GetMapping
  public String user(){
    return "user";
  }

//  @GetMapping
//  public String getUsers(HttpServletRequest request) {
//    Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
//        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//    return "admin";
//  }

}
