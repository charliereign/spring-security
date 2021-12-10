package com.charliescode.tutspringbootsecurity.service;

import com.charliescode.tutspringbootsecurity.model.AppUser;
import com.charliescode.tutspringbootsecurity.model.Role;
import com.charliescode.tutspringbootsecurity.repository.AppUserRepo;
import com.charliescode.tutspringbootsecurity.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findByUsername(username);
        if (user == null){
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        else {
            log.info("User found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("saving new user {} into the database",appUser.getName());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepo.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} into the database ", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String name, String roleName) {
        log.info("adding role {} to user {} ", roleName ,name);
        AppUser appUser = appUserRepo.findByUsername(name);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String name) {
        log.info("fetching user {}", name);
        return appUserRepo.findByUsername(name);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.info("fetching all users ");
        return appUserRepo.findAll();
    }


}
