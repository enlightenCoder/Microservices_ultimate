package com.eazybytes.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@Getter
@Setter
@ConfigurationProperties(prefix = "loans")
public class LoansContactInfoDto {

    private String message;

    private ContactDetails contactDetails;

    List<String> onCallSupport;

}
