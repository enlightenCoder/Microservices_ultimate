package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold Http response information."
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status code of Http Response.",
            example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Status message of Http Response.",
            example = "Resource found."
    )
    private String statusMsg;

}
