package com.jiao.chatonlineserver.controller;

import com.jiao.chatonlineserver.pojo.PostMessage;
import com.jiao.chatonlineserver.services.PostMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin //解决跨域问题
@Controller
@RequestMapping("/postMessage")
public class PostMessageController {
    @Autowired    // 通过在@service注解 将service实现类交给spring
    PostMessageService pms;
    //public int initPid;
    @RequestMapping("/addPost")
    //由于后台没有设置自增主键，只能借后端获取前端参数的值再进行操作
    public String addPost(PostMessage pm){
        try{
            //设置时间格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:dd:ss");
            //获取当前系统时间
            //int pid=initPid++;
            //造一个 java.util.Date()向下转型

            java.sql.Date sqlTime = new java.sql.Date(System.currentTimeMillis());
            //pm.setPid(pid+"");
            pm.setType(true);
            pm.setPost_time(sqlTime);
            this.pms.addPost(pm);
        }catch (Exception e){
            e.printStackTrace();
           return "error";
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("/selectPosts")
    public List<PostMessage> selectPosts(){
        List<PostMessage> postMessages = this.pms.selectPosts();
        if(postMessages!=null){
            return postMessages;
        }
        return null;
    }
    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam String pid){
        try {
            PostMessage postMessage = new PostMessage();
            postMessage.setPid(pid);
            this.pms.deletePost(postMessage);
        }catch (Exception e){
            return "error";
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("/selectPost")
    public PostMessage selectPost(@RequestParam String pid){
        try{
            PostMessage postMessage = new PostMessage();
            postMessage.setPid(pid);
            PostMessage postMessage1 = this.pms.selectPost(postMessage);
            if (postMessage1!=null){
                return postMessage1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/selectPostMessagesByUid")
    public List<PostMessage> selectPostMessagesByUid(@RequestParam String uid){
        PostMessage postMessage = new PostMessage();
        postMessage.setUid(uid);
        List<PostMessage> postMessageList = this.pms.selectPostByUid(postMessage);
        if (postMessageList!=null){
            return postMessageList;
        }
        return null;
    }



}
