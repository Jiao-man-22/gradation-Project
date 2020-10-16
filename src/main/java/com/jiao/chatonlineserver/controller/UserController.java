package com.jiao.chatonlineserver.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.pojo.UserTest;
import com.jiao.chatonlineserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    JSONPObject jsonpObject=null;

    @RequestMapping("/userLogin")
    public String userLogin(@PathVariable String name,@PathVariable String passworld){
        return "";
    }
    @RequestMapping("/userAll")
    public List userAll(){
        return null;
    }
    @RequestMapping("/userInsert")
    public String  userInsert(User user){
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
    @RequestMapping("/userDelete")
    public String userDelete(@RequestParam String uid){
        if (uid!=null){
            User user = new User();
            user.setUid(uid);
            this.userService.deleteUser(user);
        }else{
            System.out.println("uid===="+uid);
            return "error";
        }
        return "success";

    }
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
    @RequestMapping("/userSelect")
    public List userSelect(Model model){
        List<User> usersList = this.userService.selectUser();
        if (usersList!=null){
            return usersList;
        }else {
            return null;
        }
    }


}
