package com.wani.springrediscachetutorial.user.facade;

import com.wani.springrediscachetutorial.user.application.UserService;
import com.wani.springrediscachetutorial.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserService userService;

}
