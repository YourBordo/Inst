package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentService {
    Comment find(long id);
    List<Comment> findAllByPostId(long id);
    Comment add(Comment comment);
    Comment delete(long id);
}
