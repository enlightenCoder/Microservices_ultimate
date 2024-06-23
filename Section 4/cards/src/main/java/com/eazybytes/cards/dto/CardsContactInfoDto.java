package com.eazybytes.cards.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@Getter
@Setter
@ConfigurationProperties(prefix = "cards")
public class CardsContactInfoDto {

    private String message;

    private ContactDetails contactDetails;

    List<String> onCallSupport;

}
