package example.com.repository;

import example.com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepo {

    public static boolean addUser(User user) {
        System.out.println("Репо добавления");
        return create(user);
    }

    public static Optional<User> getUserByEmail(String email) {
        System.out.println("Репо получения");
        return getByEmail(email);
    }

    public static List<User> getAllUsers() {
        System.out.println("Репо получения всех");
        return getAll();
    }

    private static boolean create(User user) {
        String query = "INSERT INTO user_info (username, email, password) " +
                       "VALUES (?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static Optional<User> getByEmail(String email) {
        String query = "SELECT * FROM user_info WHERE email = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(getUserFromRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static List<User> getAll() {
        String query = "SELECT * FROM user_info";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<User> users = new ArrayList<>();
                while (rs.next()) {
                    users.add(getUserFromRow(rs));
                }
                return users;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static User getUserFromRow(ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String role = rs.getString("role");
        return new User(username, role, email, password);
    }
}
