package org.shoper.springmvc.webflux.repository;

import org.shoper.springmvc.webflux.pojo.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserDB {
    private volatile AtomicLong id = new AtomicLong(0);
    private Map<Long,User> userDB = new HashMap<>();
    public Long getId(){
        return id.incrementAndGet();
    }
    public Map<Long, User> getUserDB() {
        return userDB;
    }
}
