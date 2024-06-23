package com.eazybytes.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "accounts")
public class AccountsContactInfoDto {

    private String message;

    private ContactDetails contactDetails;

    private List<String> onCallSupport;

}
