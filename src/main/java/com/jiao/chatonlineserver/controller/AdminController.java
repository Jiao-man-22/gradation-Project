package com.jiao.chatonlineserver.controller;

import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/*
@Api描述了整个控制器
@ApiOperation用于方法级别的描述
@ApiParam用于方法参数
* */

@Controller
@Api(tags = "AdminController" ,description="")
public class AdminController {
    @Autowired
    UserService userService;
    boolean flag=false;

    @ResponseBody   //返回json数据
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")   //解决跨域问题
    @RequestMapping("/adminLogin")
    @ApiOperation(value = "用户登录",notes = "用户名不能为空")
    public int adminLogin(@RequestParam String username,@ApiParam("密码不能为空") @RequestParam String password){
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
