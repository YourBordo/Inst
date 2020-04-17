package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.User;

public interface UserService {
    User findByNickname(String nickname);
}
