package com.stamacake.spring.boot.Services;

import com.stamacake.spring.boot.entities.User;
import com.stamacake.spring.boot.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User find(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Нет пользователей с id = " + id));
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public long getUserCount() {
        return userRepository.count();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getUserWithMaxAgeFiltering(Integer maxAge) {
        List<User> users = this.getAll();
        if (maxAge == null) {
            return users;
        }
        users.removeIf(u->u.getAge()>maxAge);
        return users;
    }


}
