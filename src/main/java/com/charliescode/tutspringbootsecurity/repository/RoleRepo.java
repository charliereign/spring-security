package com.charliescode.tutspringbootsecurity.repository;

import com.charliescode.tutspringbootsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
