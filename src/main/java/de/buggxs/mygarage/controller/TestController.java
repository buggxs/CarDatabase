package de.buggxs.mygarage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/test")
public class TestController {

    @GetMapping(path = "/test")
    public String test() {
        return "unauthorized auth worked";
    }

    @GetMapping(path = "/test1")
    @PreAuthorize("hasAnyAuthority('user:read', 'user:write')")
    public String test1() {
        return "worked";
    }

    @GetMapping(path = "/test2")
    @PreAuthorize("hasAnyAuthority('admin:read', 'admin:write')")
    public String test2() {
        return "worked";
    }

    @GetMapping(path = "/test3")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String test3() {
        return "worked";
    }

    @GetMapping(path = "/test4")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String test4() {
        return "worked";
    }


}
