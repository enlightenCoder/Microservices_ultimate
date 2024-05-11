package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account number of customer",
            example = "123456789"
    )
    @NotEmpty(message = "Mobile Number cannot be null or empty")
    @Pattern(regexp = "$|[0-9]{9}", message = "Account number must be of 9 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of customer",
            example = "Savings"
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Bank Branch of customer",
            example = "123 New york"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;

}
