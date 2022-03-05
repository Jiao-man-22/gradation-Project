package chatonlineserver.repository;

import com.jiao.chatonlineserver.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    public void insertComment(Comment comment);
    public List<Comment> selectCommentBycpid(Comment comment);

}
