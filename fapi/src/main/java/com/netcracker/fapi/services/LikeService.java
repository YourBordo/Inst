package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.Likes;
import org.springframework.stereotype.Component;

@Component
public interface LikeService {
    Likes find(long id);
}
