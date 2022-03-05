package chatonlineserver.services.servicesImpl;

import com.jiao.chatonlineserver.pojo.Comment;
import com.jiao.chatonlineserver.repository.CommentMapper;
import com.jiao.chatonlineserver.services.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentMapper cm;
    @Override
    public void insertComment(Comment comment) {
        this.cm.insertComment(comment);
    }

    @Override
    public List<Comment> selectCommentBycpid(Comment comment) {
        List<Comment> comments = this.cm.selectCommentBycpid(comment);
        return comments;
    }
}
