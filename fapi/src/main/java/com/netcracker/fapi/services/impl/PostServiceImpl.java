package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity.Post;
import com.netcracker.fapi.services.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class PostServiceImpl implements PostService {

    @Value("${backend.server.url}")
    private String BackendUrl;


    @Override
    public Post find(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Post post = restTemplate.getForObject(BackendUrl + "/api/post/" + id, Post.class);
        return post;
    }

    @Override
    public Post add(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        Post post1 = restTemplate.postForObject(BackendUrl + "/api/post/",post, Post.class);
        return post1;
    }

    @Override
    public List<Post> findSubscribersPosts(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts = restTemplate.getForObject(BackendUrl + "/api/post/wall/"+id, Post[].class);
        return Arrays.asList(posts);
    }

    @Override
    public List<Post> findAllUserPosts(long id) {
            RestTemplate restTemplate = new RestTemplate();
            Post[] post = restTemplate.getForObject(BackendUrl + "/api/post/user="+id, Post[].class);
            return Arrays.asList(post);
        }
}
