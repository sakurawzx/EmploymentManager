package cn.thymechen.employmentmanager.service;

import cn.thymechen.employmentmanager.dao.UserRepository;
import cn.thymechen.employmentmanager.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User check(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
