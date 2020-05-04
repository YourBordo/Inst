package com.netcracker.backend.service;

import com.netcracker.backend.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentService {
    Comment find(long id);
    List<Comment> findAllByPostId(long id);
    Comment add(Comment comment);
}
