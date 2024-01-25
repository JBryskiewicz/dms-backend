package pl.dms.dms.service;

import pl.dms.dms.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(long id);
    Optional<User> findByName(String name);
}
