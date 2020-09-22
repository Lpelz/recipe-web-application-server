package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import server.domain.User;
import server.repository.UserRepository;


@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    public boolean login(User user) {
        if (userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
            return true;
        } else {
            return false;
        }
    }
}