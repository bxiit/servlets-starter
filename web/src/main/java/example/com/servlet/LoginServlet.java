package example.com.servlet;

import example.com.entity.User;
import example.com.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static example.com.util.UrlPath.LOGIN;
import static example.com.util.UrlPath.PROFILE;

@WebServlet(LOGIN)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN + ".jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        Optional<User> userByEmail = getUserByEmail(email);
        if (userByEmail.isPresent()) {
            req.getSession().setAttribute("user", userByEmail.get());
            req.authenticate(resp);
            resp.sendRedirect(PROFILE);
        } else {
            resp.sendRedirect(LOGIN + "?error&email=" + email);
        }
    }

    private Optional<User> getUserByEmail(String email) {
        return UserService.getUserByEmail(email);
    }
}
