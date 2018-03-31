package org.shoper.springmvc.webflux.repository;

import org.shoper.springmvc.webflux.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    UserDB userDB;

    public Mono<User> getUser(Long id) {
        return Mono.justOrEmpty(userDB.getUserDB().get(id));
    }

    public Collection<User> getAllUser() {
        return userDB.getUserDB().values();//Flux.fromIterable(userDB.getUserDB().values());
    }

    public void delUser(Long id) {
        userDB.getUserDB().remove(id);
    }

    public void saveUser(User user) {
        user.setId(userDB.getId());
        userDB.getUserDB().put(user.getId(), user);
    }
}
