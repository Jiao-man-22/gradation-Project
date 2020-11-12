package com.jiao.chatonlineserver.services;

import com.jiao.chatonlineserver.pojo.ChildrenPost;

import java.util.List;

public interface ChildrenPostService {
    public List<ChildrenPost> selectPostByPid(ChildrenPost childrenPost);
    public void insertPost(ChildrenPost childrenPost);
}
