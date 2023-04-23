package web.app.springboot.boot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.app.springboot.boot.dao.UserDAO;
import web.app.springboot.boot.model.User;
import web.app.springboot.boot.repo.UserRepository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User deleteUserById(Long id) {
        userRepository.delete(getUserById(id));
        return null;
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public User changeUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
