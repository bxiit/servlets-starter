package example.com.servlet;

import example.com.entity.User;
import example.com.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static example.com.util.UrlPath.ADMIN;

@WebServlet(ADMIN)
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserRepo.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("admin-page.jsp").forward(req, resp);
    }
}
