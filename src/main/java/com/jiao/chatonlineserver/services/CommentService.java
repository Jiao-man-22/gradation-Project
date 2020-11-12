package com.jiao.chatonlineserver.services;

import com.jiao.chatonlineserver.pojo.Comment;

import java.util.List;

public interface CommentService {
    public void insertComment(Comment comment);
    public List<Comment> selectCommentBycpid(Comment comment);
}
