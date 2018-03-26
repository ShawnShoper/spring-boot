package org.shoper.springmvc.webflux.api;

import org.shoper.springmvc.webflux.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AnnotationContrller {
    @GetMapping("/user/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        User user = new User(id, "ShawnShoper", 12);
        return Mono.just(user);
    }
}
