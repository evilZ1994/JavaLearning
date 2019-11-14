package top.ishavanti.jdbc.service;

import top.ishavanti.jdbc.bean.User;
import top.ishavanti.jdbc.dao.UserDAO;

/**
 * User Service
 */
public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户，失败返回空
     */
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return
     */
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return
     */
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register(User user) {
        return userDAO.addUser(user);
    }
}
