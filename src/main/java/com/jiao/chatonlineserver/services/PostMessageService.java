package com.jiao.chatonlineserver.services;

import com.jiao.chatonlineserver.pojo.PostMessage;

import java.util.List;

public interface PostMessageService {
    public void addPost(PostMessage pm);
    public void deletePost(PostMessage pm);
    public PostMessage selectPost(PostMessage pm);
    public List<PostMessage> selectPosts();
    public List<PostMessage> selectPostByUid(PostMessage pm);
    public void delPostByUid(PostMessage pm);

}
