package com.jiao.chatonlineserver.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jiao.chatonlineserver.pojo.PostMessage;
import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.pojo.UserTest;
import com.jiao.chatonlineserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    JSONPObject jsonpObject=null;
    @CrossOrigin
    @RequestMapping("/userInsert")
    public String  userInsert(User user, HttpServletRequest request){
        try {
            this.userService.insertUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
    @RequestMapping("/userTest")
    public String testUser(UserTest ut){
        if (ut!=null){
            this.userService.InsertTestUser(ut);
        }
        else{
            return "error";
        }
        return "success";
    }
    @CrossOrigin
    @RequestMapping("/userDelete")
    public String userDelete(@RequestParam String uid){
        if (uid!=null){
            User user = new User();
            user.setUid(uid);
            PostMessage postMessage = new PostMessage();
            postMessage.setUid(uid);
            this.userService.deleteUser(user,postMessage);
        }else{
            System.out.println("uid===="+uid);
            return "error";
        }
        return "success";

    }
    @CrossOrigin
    @RequestMapping("/userUpdate")
    public String userUpdate(User user){
        if (user!=null){
            this.userService.updateUSer(user);
        }else {
            return "error";
        }
        return "success";
    }
    @ResponseBody
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //解决跨域问题
    @RequestMapping("/userSelect")
    public List userSelect(Model model){
        List<User> usersList = this.userService.selectUsers();
        if (usersList!=null){
            return usersList;
        }else {
            return null;
        }
    }
    @ResponseBody
    @RequestMapping("/userSelectByName")
    public User userSelectByName(@RequestParam String name){
        User user = new User();
        user.setName(name);
        User user_1 = this.userService.selectUser(user);
        return user_1;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/userLogin")
    public User userLogin(@RequestParam String name,@RequestParam String password){
        User user = new User();
        //将参数绑定到pojo
        if (name!=null && password!=null){
            user.setName(name);
            user.setPassword(password);
            User user1 = this.userService.selectUser(user);
            if (user1!=null && user1.getPassword().equals(user.getPassword())){
                return  user1;
            }
        }
        return null;
    }


}
