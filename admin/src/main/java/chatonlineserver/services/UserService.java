package chatonlineserver.services;

import com.jiao.chatonlineserver.pojo.PostMessage;
import com.jiao.chatonlineserver.pojo.User;
import com.jiao.chatonlineserver.pojo.UserTest;

import java.util.List;

public interface UserService {
    public void insertUser(User user);
    public void InsertTestUser(UserTest ut);
    public void deleteUser(User user, PostMessage pm);
    public void updateUSer(User user);
    public List<User> selectUsers();
    public User selectUser(User user);

}
