package com.claim.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Adding in the Spring Annotations allowing spring to scan the packages for beans(They will need to be imported)
@Configuration
@EnableJpaRepositories(basePackages="com.claim.repository")
@EntityScan(basePackages="com.claim.entity")

public class ApplicationConfig {

}
