package org.shoper.springmvc.webflux.api;

import com.daqsoft.commons.responseentity.BaseResponse;
import com.daqsoft.commons.responseentity.ResponseBuilder;
import org.shoper.springmvc.webflux.pojo.User;
import org.shoper.springmvc.webflux.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AnnotationContrller {
    @Autowired
    UserServer userServer;

    @GetMapping("/user/{id}")
    public Mono<BaseResponse> getUser(@PathVariable Long id) {
        return Mono.justOrEmpty(ResponseBuilder.custom().data(new User(id, "ShawnShoper", 12)).build());
    }

    @GetMapping("/user")
    public Mono<BaseResponse> getAllUser() {
        return Mono.justOrEmpty(ResponseBuilder.custom().data(userServer.getAllUser()).build());
    }

    @DeleteMapping("/user/{id}")
    public Mono<BaseResponse> delUser(@PathVariable Long id) {
        userServer.delUser(id);
        return Mono.justOrEmpty(ResponseBuilder.custom().build());
    }

    @PostMapping("/user")
    public Mono<BaseResponse> saveUser(User user) {
        userServer.saveUser(user);
        return Mono.justOrEmpty(ResponseBuilder.custom().build());
    }
}
