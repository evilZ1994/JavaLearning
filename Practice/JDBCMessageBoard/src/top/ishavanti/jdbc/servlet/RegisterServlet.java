package top.ishavanti.jdbc.servlet;

import top.ishavanti.jdbc.bean.User;
import top.ishavanti.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class RegisterServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathName = req.getServletPath();
        if (Objects.equals("/regPrompt.do", pathName)) {
            // 跳转到注册页面
            req.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(req, resp);
        } else if (Objects.equals("/register.do", pathName)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean result = userService.register(user);
            if (result) {
                req.getRequestDispatcher("/main.do").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        userService = null;
    }
}
