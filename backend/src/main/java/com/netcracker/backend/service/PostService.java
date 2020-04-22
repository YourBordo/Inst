package com.netcracker.backend.service;

import com.netcracker.backend.entity.Post;
import org.springframework.stereotype.Component;

@Component
public interface PostService {
    Post find(long id);
    Post add(Post post);
    }
