package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity.User;
import com.netcracker.fapi.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component/*сервис, реализующий запрос на бэкенд*/
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String BackendUrl;

    @Override
    public User findByNickname(String nickname) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(BackendUrl + "/api/user/" + nickname, User.class);
        return user;
    }
}
