package pl.dms.dms.service;

import pl.dms.dms.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    User createUser(User user);
}
