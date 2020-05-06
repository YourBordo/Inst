package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
     User find(String name);
     User find(long id);
     User add(User user);
     List<User>getSubscriptions(long id);
}
