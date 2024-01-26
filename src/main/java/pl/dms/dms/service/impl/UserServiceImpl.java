package pl.dms.dms.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dms.dms.domain.Role;
import pl.dms.dms.domain.User;
import pl.dms.dms.repository.RoleRepository;
import pl.dms.dms.repository.UserRepository;
import pl.dms.dms.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final String USER_ROLE = "ROLE_USER";

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        Optional<Role> userRole = roleRepository.findByName(USER_ROLE);
        if (userRole.isPresent()) {
            user.setRoles(new HashSet<>(Arrays.asList(userRole.get())));
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setRoles(user.getRoles());
            existingUser.setSessions(user.getSessions());
            return userRepository.save(existingUser);
        }
        return null;
    }
}