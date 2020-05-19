package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.Comment;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.entity.User;
import com.netcracker.backend.repository.CommentRepository;
import com.netcracker.backend.repository.PostRepository;
import com.netcracker.backend.repository.UserRepository;
import com.netcracker.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public User find(String name) {
        return  userRepository.findByNickname(name);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getSubscriptions(long id) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(id));
        if(user.isPresent()){
            return user.get().getSubscribedTo();
        }
        return new ArrayList<>();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByEmail(login);
    }


    @Override
    public User find(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByComment(long id) {
        Comment comment = commentRepository.findById(id);

        return userRepository.findByComments(Collections.singletonList(comment));
    }

    @Override
    public User findByPost(long id) {
        Post post = postRepository.findById(id);

        return userRepository.findByPosts(Collections.singletonList(post));
    }
}
