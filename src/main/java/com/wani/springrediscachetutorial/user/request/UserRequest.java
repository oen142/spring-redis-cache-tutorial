package com.wani.springrediscachetutorial.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {

    private String username;
    private String password;
    private String email;

    public UserRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
