package cn.thymechen.employmentmanager.dao;

import cn.thymechen.employmentmanager.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
