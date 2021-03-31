package com.wani.springrediscachetutorial.user.ui;

import com.wani.springrediscachetutorial.common.CacheKey;
import com.wani.springrediscachetutorial.user.application.UserService;
import com.wani.springrediscachetutorial.user.entity.User;
import com.wani.springrediscachetutorial.user.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User postUser(@RequestBody UserRequest request) {
        return userService.save(request);
    }

    @CachePut(value = CacheKey.USER, key = "#request.username")
    @PutMapping("/user")
    @ResponseBody
    public User putUser(@RequestBody UserRequest request) {
        return userService.save(request);
    }

    @CacheEvict(value = CacheKey.USER, key = "#id")
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return true;
    }


}
