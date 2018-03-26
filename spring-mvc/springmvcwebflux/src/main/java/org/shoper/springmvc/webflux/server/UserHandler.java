package org.shoper.springmvc.webflux.server;

import org.shoper.springmvc.webflux.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class UserHandler {
    public Mono<ServerResponse> getUser(ServerRequest serverRequest) {
        Optional<String> id = serverRequest.queryParam("id");
        User user = new User(Long.valueOf(id.get()), "s", 16);
        return ServerResponse.ok().body(Mono.just(user), User.class);
    }
}
