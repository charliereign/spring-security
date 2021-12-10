package com.charliescode.tutspringbootsecurity.repository;

import com.charliescode.tutspringbootsecurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
