package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Customer",
        description = "Schema to hold customer and account input information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Name of customer",
            example = "Eazy Bytes"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 100, message = "The minimum characters for name is 5 and maximum 100")
    private String name;

    @Schema(
            description = "Email of customer",
            example = "EazyBytes@gmail.com"
    )
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email is not valid")
    private String email;

    @Schema(
            description = "Contact number of customer",
            example = "51234567"
    )
    @NotEmpty(message = "Mobile Number cannot be null or empty")
    private String mobileNumber;

    @Schema(
            description = "Account info of customer"
    )
    private AccountsDto accountsDto;

}
