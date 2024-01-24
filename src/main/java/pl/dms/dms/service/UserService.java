package pl.dms.dms.service;

import pl.dms.dms.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(long id);
    User findByName(String name);
    User saveUser(User user);
    User editUser(User user);
    String findEmail(String email);
    User findUserByEmail(String email);

    User deleteUser(User user);
}
