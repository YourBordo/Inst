package com.netcracker.backend.service.impl;
import com.netcracker.backend.entity.Post;
import com.netcracker.backend.repository.PostRepository;
import com.netcracker.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
