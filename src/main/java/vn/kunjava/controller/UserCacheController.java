package vn.kunjava.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.kunjava.model.UserCache;
import vn.kunjava.service.impl.UserCacheServiceImpl;

@RestController
@RequestMapping("/user")
public class UserCacheController {

    private final UserCacheServiceImpl userCacheService;

    public UserCacheController(UserCacheServiceImpl userCacheService) {
        this.userCacheService = userCacheService;
    }

    @GetMapping("/cache/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserCache getUserById(@PathVariable Long id) {
        return userCacheService.getUserById(id);
    }
}
