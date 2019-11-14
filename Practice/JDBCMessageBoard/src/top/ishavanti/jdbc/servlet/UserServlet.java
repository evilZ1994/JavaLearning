package top.ishavanti.jdbc.servlet;

import top.ishavanti.jdbc.bean.User;
import top.ishavanti.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathName = req.getServletPath();
        if (Objects.equals("/userInfo.do", pathName)) {
            req.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(req, resp);
        } else if (Objects.equals("/editUserPrompt.do", pathName)) {
            long id = Long.valueOf(req.getParameter("id"));
            User user = userService.getUserById(id);
            if (null != user) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/views/biz/edit_user.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(req, resp);
            }
        } else if (Objects.equals("/editUser.do", pathName)) {
            long id = Long.valueOf(req.getParameter("id"));
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String realName = req.getParameter("realName");
            String birthday = req.getParameter("birthday");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setRealName(realName);
            try {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            } catch (ParseException e) {
                System.out.println("格式化Birthday异常");
                e.printStackTrace();
            }
            user.setPhone(phone);
            user.setAddress(address);
            boolean result = userService.updateUser(user);
            if (result) {
                req.getSession().setAttribute("user", user);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
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
