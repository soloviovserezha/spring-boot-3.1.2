package web.app.springboot.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.springboot.boot.dao.UserDAO;
import web.app.springboot.boot.model.User;
import web.app.springboot.boot.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public User deleteUserById(Long id) {
        return userDAO.deleteUserById(getUserById(id).getId());
    }

    @Transactional
    @Override
    public void deleteAllUsers() {
        userDAO.deleteAllUsers();
    }

    @Transactional
    @Override
    public User changeUser(User user) {
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setEmail(user.getEmail());
        return userDAO.changeUser(user);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
