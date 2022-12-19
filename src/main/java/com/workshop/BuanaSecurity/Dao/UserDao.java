package com.workshop.BuanaSecurity.Dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Repository
public class UserDao {

    public final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "iamfaqih.rochman@gmail.com","password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),

            new User(
                    "elinurlaili@gmail.com","passwordlaptop",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );


    public UserDetails findByUserEmail(String email){
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));

    }

}
