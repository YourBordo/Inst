package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostService {
    Post find(long id);
    Post add(Post post);
    List<Post> findSubscribersPosts(long id);
    List<Post> findAllUserPosts(long id);

    }
