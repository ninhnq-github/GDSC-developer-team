package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.AppUserRole;
import com.example.demo.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "registration")
@AllArgsConstructor
public class RegistrationController {

  private final RegistrationService registrationService;

  @GetMapping
  public String register(Model model) {
    AppUser appUser = new AppUser();
    model.addAttribute("appUser", appUser);
    return "register";
  }

  @PostMapping
  public String register(AppUser appUser) {

    registrationService.register(appUser);
    return "confirmmailrequest";
  }

  @GetMapping(path = "confirm")
  public String Confirm(@RequestParam("token") String token) {
    registrationService.confirmToken(token);

    return "success";
  }

}
