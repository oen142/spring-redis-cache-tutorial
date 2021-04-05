package com.wani.springrediscachetutorial.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityConstants {


    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_CONFLICT = ResponseEntity.status(HttpStatus.CONFLICT).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_OK = ResponseEntity.status(HttpStatus.OK).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_NO_CONTENT = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_BAD_REQUEST = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_NOT_FOUND = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    public static final ResponseEntity<String> RESPONSE_ENTITY_BAD_REQUEST_NO_USER = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("미가입 회원입니다.");


    private ResponseEntityConstants() {
    }

}
