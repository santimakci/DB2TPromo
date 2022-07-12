package com.zinbig.mongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
// @EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.zinbig.mongodemo.repositories.JpaRepositories")
public class MongodemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MongodemoApplication.class, args);
  }
}
