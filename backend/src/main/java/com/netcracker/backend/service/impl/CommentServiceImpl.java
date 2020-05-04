package com.netcracker.backend.service.impl;

import com.netcracker.backend.entity.Comment;
import com.netcracker.backend.repository.CommentRepository;
import com.netcracker.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment find(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAllByPostId(long id) {
        return commentRepository.findAllByPostId(id);
    }

    @Override
    public Comment add(Comment comment) {
        Comment current = new Comment
                (comment.getText(), comment.getDate(), comment.getUser(), comment.getPost());
        return commentRepository.save(current);
    }
}
