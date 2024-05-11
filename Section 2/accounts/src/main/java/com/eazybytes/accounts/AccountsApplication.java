package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jakarta.persistence.Version;
import jdk.jfr.Description;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@OpenAPIDefinition(
        info = @Info(

                title = "Accounts Microservices REST Api Documentation",
                description = "Eazybank Accounts Microservice REST Api documentation",
                version = "v1",
                contact = @Contact(
                        name = "Christopher Ami",
                        email = "christopherami87@gmail.com",
                        url= "https://eazybank.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://eazybank.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Eazybank Accounts Microservice REST Api documentation",
                url = "https://eazybank.com"
        )
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
