package com.jiao.chatonlineserver.services.servicesImpl;

import com.jiao.chatonlineserver.pojo.ChildrenPost;
import com.jiao.chatonlineserver.repository.ChildrenPostMapper;
import com.jiao.chatonlineserver.services.ChildrenPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ChildrenPostServiceImpl implements ChildrenPostService {
    @Resource
    ChildrenPostMapper cpm;
    @Override
    public List<ChildrenPost> selectPostByPid(ChildrenPost childrenPost) {
        List<ChildrenPost> childrenPosts = this.cpm.selectPostByPid(childrenPost);
        return childrenPosts;
    }

    @Override
    public void insertPost(ChildrenPost childrenPost) {
        this.cpm.insertChildrenPost(childrenPost);

    }
}
