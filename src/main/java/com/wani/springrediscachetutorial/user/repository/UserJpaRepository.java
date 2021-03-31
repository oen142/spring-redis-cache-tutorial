package com.wani.springrediscachetutorial.user.repository;

import com.wani.springrediscachetutorial.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
