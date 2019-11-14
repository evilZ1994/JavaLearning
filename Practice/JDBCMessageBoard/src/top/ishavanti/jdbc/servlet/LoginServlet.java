package top.ishavanti.jdbc.servlet;

import top.ishavanti.jdbc.bean.User;
import top.ishavanti.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录到的Servlet
 */
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (null != user) {
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/message/list.do").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.do").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        userService = null;
    }
}