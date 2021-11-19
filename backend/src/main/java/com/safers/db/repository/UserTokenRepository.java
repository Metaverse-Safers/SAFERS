package com.safers.db.repository;

import com.safers.db.entity.user.Token;
import com.safers.db.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<Token, User> {
    Optional<Token> findByUserId(User user);
}
