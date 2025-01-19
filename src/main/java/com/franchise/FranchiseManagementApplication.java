package com.franchise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.franchise.model")
@EnableJpaRepositories("com.franchise.repository")
public class FranchiseManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(FranchiseManagementApplication.class, args);
    }
}
