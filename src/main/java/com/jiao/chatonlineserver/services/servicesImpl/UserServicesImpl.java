package com.jiao.chatonlineserver.services.servicesImpl;

import com.jiao.chatonlineserver.pojo.PostMessage;
import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.pojo.UserTest;
import com.jiao.chatonlineserver.repository.PostMessageMapper;
import com.jiao.chatonlineserver.repository.UserMapper;
import com.jiao.chatonlineserver.services.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service

public class UserServicesImpl implements UserService {
    @Resource
    UserMapper userDao;
    @Resource
    PostMessageMapper pmm;

    @Override
    @Transactional
    public void insertUser(User user) {
        if (user!=null){
            user.setRoleID("user");
            this.userDao.insertUser(user);
        }else{
            System.out.println("user=="+user);
        }

    }

    @Override
    public void InsertTestUser(UserTest ut) {
        if (ut!=null){
            this.userDao.insertTestUser(ut);
        }else{
            System.out.println("ut==="+ut);
        }


    }

    @Override
    @Transactional
    public void deleteUser(@Param("user") User user, PostMessage pm) {
        if (user!=null && pm!=null){
            //先删除从表中的数据在删除主表的
            this.pmm.delPostByUid(pm);
            this.userDao.deleteUser(user);
        }

    }

    @Override
    public void updateUSer(User user) {
        if (user!=null){
            this.userDao.updateUser(user);
        }else{
            System.out.println("user==="+user);
        }
    }

    @Override
    public List<User> selectUsers() {
        List<User> userslist = this.userDao.selectUsers();
        return userslist;
    }

    @Override
    public User selectUser(User user) {
        User user_1 = this.userDao.selectUser(user);
        return user_1;
    }
}
