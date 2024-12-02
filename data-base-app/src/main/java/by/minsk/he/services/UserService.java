package by.minsk.he.services;

import by.minsk.he.models.UserModel;
import by.minsk.he.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserModel insertUser(UserModel user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new IllegalArgumentException("User with login '" + user.getLogin() + "' already exists.");
        }
    }

    public UserModel findUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel updateUser(UserModel user) {
        if (!userRepository.existsById(user.getUserId())) {
            throw new NoSuchElementException("Car not found with " + user.getUserId());
        }
        return userRepository.save(user);
    }

    @Transactional
    public UserModel deleteUser(UUID id) throws NoSuchElementException {
        UserModel user = findUserById(id);
        userRepository.delete(user);
        return user;
    }
}
