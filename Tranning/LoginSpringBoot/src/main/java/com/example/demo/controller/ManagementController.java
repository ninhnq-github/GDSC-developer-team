package com.example.demo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ManagementController {

  @GetMapping
  @PreAuthorize("hasAnyRole('ADMIN','SUPPORTER')")
  public String admin(){
    return "admin";
  }

  @GetMapping(path = "read")
  @PreAuthorize("hasAuthority('admin:read')")
  public String read(){
    return "adminread";
  }

  @GetMapping(path = "write")
  @PreAuthorize("hasAuthority('admin:write')")
  public String write(){
    return "adminwrite";
  }


}
