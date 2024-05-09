package example.com.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static example.com.util.UrlPath.*;

@WebFilter(ANY)
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION, HELLO, MAIN);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        if (isPublicURI(uri) || isUserLoggedIn(request)) {
            filterChain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendRedirect(LOGIN);
        }
    }

    private boolean isUserLoggedIn(ServletRequest request) {
        return ((HttpServletRequest) request).getSession().getAttribute("user") != null;
    }

    private boolean isPublicURI(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }
}
