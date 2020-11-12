package com.jiao.chatonlineserver.repository;

import com.jiao.chatonlineserver.pojo.ChildrenPost;

import java.util.List;

public interface ChildrenPostMapper {
    public List<ChildrenPost>selectPostByPid(ChildrenPost cp);
    public void insertChildrenPost(ChildrenPost cp);
}
