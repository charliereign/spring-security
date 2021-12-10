package com.charliescode.tutspringbootsecurity.service;

import com.charliescode.tutspringbootsecurity.model.AppUser;
import com.charliescode.tutspringbootsecurity.model.Role;
import org.apache.catalina.User;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String name, String roleName);
    AppUser getUser(String name);
    List<AppUser> getAllUsers();
}
