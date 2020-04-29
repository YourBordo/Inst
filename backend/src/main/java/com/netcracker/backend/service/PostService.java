package com.netcracker.backend.service;

import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostService {
    Post find(long id);
    Post add(Post post);
    List<Post> findSubscribersPosts(long id);
    List<Post> findAllUserPosts(long id);

    }
