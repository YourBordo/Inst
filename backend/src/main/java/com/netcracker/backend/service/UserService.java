package com.netcracker.backend.service;

import com.netcracker.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
     User find(String name);
     User add(User user );
//
}
