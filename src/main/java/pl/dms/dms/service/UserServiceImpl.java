package pl.dms.dms.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dms.dms.domain.User;
import pl.dms.dms.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User saveUser(User user) {
        user.setEnabled(true);

        userRepository.save(user);
        return user;
    }

    @Override
    public User editUser(User user) {
        return user;
    }

    @Override
    public String findEmail(String email) {
        try{
            return userRepository.findByEmail(email).getEmail();
        }catch (NullPointerException e){
            return "DOES_NOT_EXIST";
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }
}
