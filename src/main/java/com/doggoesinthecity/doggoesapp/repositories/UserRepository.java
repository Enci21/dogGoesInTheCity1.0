package com.doggoesinthecity.doggoesapp.repositories;

import com.doggoesinthecity.doggoesapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}