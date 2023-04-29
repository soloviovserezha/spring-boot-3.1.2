package web.app.springboot.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.app.springboot.boot.model.User;
import web.app.springboot.boot.repo.UserRepository;
import web.app.springboot.boot.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
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
    @Transactional
    public User deleteUserById(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    @Transactional
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    @Transactional
    public User changeUser(User user) {
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setEmail(user.getEmail());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }
}
