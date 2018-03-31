package org.shoper.springmvc.webflux.server;

import com.daqsoft.commons.responseentity.BaseResponse;
import com.daqsoft.commons.responseentity.ResponseBuilder;
import org.shoper.springmvc.webflux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {
    @Autowired
    UserDB user;

    public Mono<ServerResponse> getUser(ServerRequest serverRequest) {
        Long id = Long.valueOf(serverRequest.pathVariable("id"));
        return ServerResponse.ok().body(Mono.justOrEmpty(ResponseBuilder.custom().data(user.getUserDB().get(id)).build()), BaseResponse.class);
    }
}
