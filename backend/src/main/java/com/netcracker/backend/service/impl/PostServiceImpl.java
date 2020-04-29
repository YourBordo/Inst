package com.netcracker.backend.service.impl;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import com.netcracker.backend.repository.PostRepository;
import com.netcracker.backend.repository.UserRepository;
import com.netcracker.backend.service.PostService;
import com.netcracker.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Collections.addAll;

@Component
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Post find(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post add(Post post) {
        Post current = new Post(post.getDate(), post.getId(),
                post.getPhoto(), post.getPlace(), post.getText(), post.getUser());
        return postRepository.save(current);
    }
    @Autowired
    UserService userService;
    @Override
    public List<Post> findSubscribersPosts(long id) {
       List<User> users = userService.getSubscriptions(id);//те, на кого подписан

        ArrayList<Post> posts = new ArrayList<>();

       for(User user: users)
       {
               posts.addAll(this.findAllUserPosts(user.getId()));
       }

       Collections.sort(posts);
       return posts;
    }

    @Override
    public List<Post> findAllUserPosts(long id) {
        return postRepository.findAllByUserId(id);
    }
}
