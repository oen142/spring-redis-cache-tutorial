package com.wani.springrediscachetutorial.user.entity.redis;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@Builder
@RedisHash("student")
public class Student {

    @Id
    private Long studentId;
    private String name;

    public void update(String name) {
        this.name = name;
    }
}
