package web.app.springboot.boot.service;

import web.app.springboot.boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserById(Long id);

    User deleteUserById(Long id);

    void deleteAllUsers();

    User changeUser(User user);

    void addUser(User user);
}
