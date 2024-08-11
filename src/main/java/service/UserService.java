package service;
import lombok.RequiredArgsConstructor;
import entity.User;
import dao.UserDAO;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public void save(User user) throws IOException {
        userDAO.save(user);
    }

    public List<User> getAllUser() throws IOException {
        return userDAO.findAll();
    }
}
