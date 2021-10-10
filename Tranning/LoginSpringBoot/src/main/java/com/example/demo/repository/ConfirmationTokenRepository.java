package com.example.demo.repository;


import com.example.demo.entity.ConfirmationToken;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ConfirmationTokenRepository
    extends JpaRepository<ConfirmationToken, Long> {
  Optional<ConfirmationToken> findByToken(String token);

  @Transactional
  @Modifying
  @Query("UPDATE ConfirmationToken c " +
      "SET c.confirmedAt = ?2 " +
      "WHERE c.token = ?1")
  int updateConfirmedAt(String token,
      LocalDateTime confirmedAt);
}