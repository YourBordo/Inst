package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity.Complaint;
import com.netcracker.fapi.entity.User;
import com.netcracker.fapi.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component/*сервис, реализующий запрос на бэкенд*/
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String BackendUrl;


    @Override
    public User find(String name) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(BackendUrl + "/api/user/" + name, User.class);
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
