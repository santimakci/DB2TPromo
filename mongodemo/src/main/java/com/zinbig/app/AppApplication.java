package com.zinbig.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.zinbig.app.repositories")
@EnableElasticsearchRepositories("com.zinbig.app.repositories.ElasticRepostories")
@EnableJpaRepositories(basePackages = "com.zinbig.app.repositories.JpaRepositories")
public class AppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }
}
