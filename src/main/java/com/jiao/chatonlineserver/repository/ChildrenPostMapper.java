package com.jiao.chatonlineserver.repository;

import com.jiao.chatonlineserver.pojo.ChildrenPost;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChildrenPostMapper {
    public List<ChildrenPost>selectPostByPid(ChildrenPost cp);
    public void insertChildrenPost(ChildrenPost cp);
    @Select("select *from childrenPost where pid=#{pid}")
    public List<ChildrenPost>selectPostByPidAnn(ChildrenPost cp);
}
