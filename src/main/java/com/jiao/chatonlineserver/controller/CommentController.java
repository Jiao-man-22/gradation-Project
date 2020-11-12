package com.jiao.chatonlineserver.controller;

import com.jiao.chatonlineserver.pojo.Comment;
import com.jiao.chatonlineserver.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService cs;
    @RequestMapping("/insertComment")
    public String insertComment(@RequestParam String name,@RequestParam String text,@RequestParam String cpid){
        Comment comment = new Comment();
        comment.setText(text);
        comment.setName(name);
        comment.setCpid(Integer.parseInt(cpid));
        cs.insertComment(comment);
        return "success";
    }
    @ResponseBody
    @RequestMapping("/selectCommentByCip")
    public List<Comment>selectCommentByCip(@RequestParam  String cpid){
        Comment comment = new Comment();
        comment.setCpid(Integer.parseInt(cpid));
        List<Comment> comments = this.cs.selectCommentBycpid(comment);
        return comments;
    }
}
