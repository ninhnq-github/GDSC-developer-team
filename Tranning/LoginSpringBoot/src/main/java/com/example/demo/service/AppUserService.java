package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.ConfirmationToken;
import com.example.demo.repository.AppUserRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

  private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

  private final AppUserRepository appUserRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final ConfirmationTokenService confirmationTokenService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return appUserRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
  }

  public String signUpUser(AppUser appUser) {
    boolean userExists =
        appUserRepository.findByUsername(appUser.getUsername()).isPresent();
    if (userExists) {
      throw new IllegalStateException("username already taken");
    }

    //Ma hoa password va set password
    String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    appUser.setPassword(encodedPassword);
    appUserRepository.save(appUser);

    //Tao random token
    String token = UUID.randomUUID().toString();

    //Luu token xuong database
    ConfirmationToken confirmationToken = new ConfirmationToken(
        token,
        LocalDateTime.now(),
        LocalDateTime.now().plusMinutes(15),
        appUser
    );
    confirmationTokenService.saveConfirmationToken(confirmationToken);

    return token;
  }

  public int enableAppUser(String email) {
    return appUserRepository.enableAppUser(email);
  }
}
