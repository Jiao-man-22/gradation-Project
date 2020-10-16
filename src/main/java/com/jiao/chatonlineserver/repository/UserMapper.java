package com.jiao.chatonlineserver.repository;

import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.pojo.UserTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    public void insertUser(User user);
    public void insertTestUser(UserTest userTest);
    public void deleteUser(User user);
    public void updateUser(User user);
    public List<User> selectUsers();
}
