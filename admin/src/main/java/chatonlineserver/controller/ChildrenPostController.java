package chatonlineserver.controller;

import com.jiao.chatonlineserver.pojo.ChildrenPost;
import com.jiao.chatonlineserver.services.ChildrenPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/ChildrenPost")
public class ChildrenPostController {
    @Autowired
    ChildrenPostService cps;
    @RequestMapping("/selectPostByPid")
    @ResponseBody
    public List<ChildrenPost> selectPostByPid(@RequestParam String pid){
        ChildrenPost childrenPost = new ChildrenPost();
        childrenPost.setPid(pid);
        List<ChildrenPost> childrenPosts = this.cps.selectPostByPid(childrenPost);
        return childrenPosts;
    }
    @RequestMapping("/insertPost")
    public String  insertPost(@RequestParam String spokesman,@RequestParam String text,@RequestParam String pid){
        ChildrenPost childrenPost = new ChildrenPost();
        childrenPost.setPid(pid);
        childrenPost.setSpokesman(spokesman);
        childrenPost.setText(text);
        this.cps.insertPost(childrenPost);
        return "success";
    }
}
