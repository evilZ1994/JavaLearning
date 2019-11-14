package top.ishavanti.jdbc.filter;

import top.ishavanti.jdbc.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user = (User)((HttpServletRequest)servletRequest).getSession().getAttribute("user");
        servletRequest.setAttribute("user", user);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
