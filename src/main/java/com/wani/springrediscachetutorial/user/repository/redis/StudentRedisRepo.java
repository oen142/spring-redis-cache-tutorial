package com.wani.springrediscachetutorial.user.repository.redis;

import com.wani.springrediscachetutorial.user.entity.redis.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRedisRepo extends CrudRepository<Student, Long> {
}
