package chatonlineserver.services.servicesImpl;

import com.jiao.chatonlineserver.pojo.PostMessage;
import com.jiao.chatonlineserver.repository.PostMessageMapper;
import com.jiao.chatonlineserver.services.PostMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostMessageServicesImpl  implements PostMessageService {
    @Resource
    PostMessageMapper pmm;
    @Override
    public void addPost(PostMessage pm) {
        this.pmm.addPost(pm);
    }
    @Override
    public void deletePost(PostMessage pm) {
        try{
            this.pmm.deletePost(pm);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public PostMessage selectPost(PostMessage pm) {
        PostMessage postMessage = this.pmm.selectPost(pm);
        if (postMessage!=null){
            return postMessage;
        }
        return null;
    }

    @Override
    public List<PostMessage> selectPosts() {
        List<PostMessage> postMessages = this.pmm.selectPosts();
        return postMessages;
    }

    @Override
    public List<PostMessage> selectPostByUid(PostMessage pm) {
        try{
            List<PostMessage> postMessageList = this.pmm.selectPostByUid(pm);
            if (postMessageList!=null){
                return postMessageList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delPostByUid(PostMessage pm) {
        this.pmm.delPostByUid(pm);
    }

    @Override
    public List<PostMessage> selectPostByCourse(PostMessage pm) {
        List<PostMessage> postMessages = this.pmm.selectPostByCourse(pm);
        return postMessages;
    }
}
