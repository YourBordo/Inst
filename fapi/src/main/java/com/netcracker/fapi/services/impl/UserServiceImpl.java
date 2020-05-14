package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity.Complaint;
import com.netcracker.fapi.entity.User;
import com.netcracker.fapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("customUserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Value("${backend.server.url}")
    private String BackendUrl;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User
                (user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }
    @Override
    public User find(String name) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(BackendUrl + "/api/user/" + name, User.class);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(BackendUrl +
                "/api/user/login/" + login, User.class);
    return user;
    }

    @Override
    public User find(long id) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(BackendUrl + "/api/user/" + id, User.class);
        return user;
    }

    @Override
    public User add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        User user1 = restTemplate.postForObject(BackendUrl + "/api/user/",user, User.class);
        return user1;
    }

    @Override
    public List<User> getSubscriptions(long id) {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject(BackendUrl +
                "/api/user/subscriptions/"+id, User[].class);
        return Arrays.asList(users);
    }
}
