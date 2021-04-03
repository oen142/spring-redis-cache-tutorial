package com.wani.springrediscachetutorial.aop;

import com.wani.springrediscachetutorial.common.UserLevel;
import com.wani.springrediscachetutorial.user.application.LoginService;
import com.wani.springrediscachetutorial.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckLoginStatusAop {

    private final LoginService loginService;
    private final UserService userService;

    @Before(value = "@annotation(CheckLoginStatus) && @annotation(checkLoginStatus)")
    public void checkStatus(CheckLoginStatus checkLoginStatus) {
        UserLevel auth = checkLoginStatus.auth();

        switch (auth) {
            case USER:
                allUserLoginStatus();
                break;

        }

    }

    private void allUserLoginStatus() {
        boolean isLoginUser = loginService.isLoginUser();

        if (!isLoginUser) {
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "user is not authorized") {};
        }
    }


}
