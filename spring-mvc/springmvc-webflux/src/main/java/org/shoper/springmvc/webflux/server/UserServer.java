package org.shoper.springmvc.webflux.server;

import org.shoper.springmvc.webflux.pojo.User;
import org.shoper.springmvc.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Service
public class UserServer {
    @Autowired
    UserRepository userRepository;

    public Mono<User> getUser(Long id) {
        return userRepository.getUser(id);
    }

    public Collection<User> getAllUser() {
        return userRepository.getAllUser();
    }

    public void delUser(Long id) {

        userRepository.delUser(id);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}
