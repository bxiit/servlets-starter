package example.com.servlet;

import example.com.entity.User;
import example.com.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static example.com.util.UrlPath.LOGIN;
import static example.com.util.UrlPath.REGISTRATION;

@WebServlet(REGISTRATION)
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(REGISTRATION + ".jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserFromRegistration(req);
        if (UserService.addUser(user)) {
            resp.sendRedirect(req.getContextPath() + LOGIN + "?email=" + user.getEmail());
        } else {
            resp.sendRedirect(req.getContextPath() + LOGIN +"?error="
                              + "a user with email " + user.getEmail() + " already exists"
                              + "&email=" + user.getEmail());
        }
    }

    private User getUserFromRegistration(HttpServletRequest req) {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        return new User(username, "user", email, password);
    }
}
