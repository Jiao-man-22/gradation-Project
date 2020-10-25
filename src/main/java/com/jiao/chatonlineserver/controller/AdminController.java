package com.jiao.chatonlineserver.controller;

import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    boolean flag=false;

    @ResponseBody   //返回json数据
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //解决跨域问题
    @RequestMapping("/adminLogin")
    public int adminLogin(@RequestParam String username, @RequestParam String password){
        try{
            if (username==null && password==null){
                return 0;
            }else if (username!=null&&password!=null){
                User user = new User();
                user.setName(username);
                User user1 = this.userService.selectUser(user);
                if (user1!=null && user1.getPassword().equals(password) &&user1.getRoleID().equals("admin") ) {
                    return 1;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
