package cn.thymechen.employmentmanager.service;

import cn.thymechen.employmentmanager.data.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * 查询用户
     * @param username 用户名
     * @param password 密码
     * @return User 实例
     */
    User check(String username, String password);
}
