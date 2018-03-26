package org.shoper.springmvc.webflux.conf;

import org.shoper.springmvc.webflux.server.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutingConfiguration {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/{user}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), userHandler::getUser);
    }
}
