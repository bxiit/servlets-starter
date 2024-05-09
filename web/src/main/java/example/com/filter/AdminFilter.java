package example.com.filter;

import example.com.entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static example.com.util.UrlPath.*;

@WebFilter(ADMIN)
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user != null && Objects.equals(user.getRole(), "admin")) {
            filterChain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendRedirect(PROFILE);
        }
    }
}
