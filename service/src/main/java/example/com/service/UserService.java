package example.com.service;

import example.com.entity.User;
import example.com.repository.UserRepo;

import java.util.Optional;

public class UserService {

    public static Optional<User> getUserByEmail(String email) {
        System.out.println("Сервис получения");
        return UserRepo.getUserByEmail(email);
    }

    public static boolean addUser(User user) {
        System.out.println("Сервис добавления");
        if (isEmailAlreadyTaken(user.getEmail())) {
            return false;
        }
        return UserRepo.addUser(user);
    }

    public static boolean isEmailAlreadyTaken(String email) {
        return getUserByEmail(email).isPresent();
    }
}
