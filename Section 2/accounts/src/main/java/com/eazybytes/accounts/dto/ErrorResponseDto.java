package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Error",
        description = "Schema to hold errors when exception occured in controller."
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "Url used and getting error.",
            example = "http://eazybyte/create"
    )
    private String apiPath;

    @Schema(
            description = "Error Code.",
            example = "500"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Message from the exception.",
            example = "Internal Server Error."
    )
    private String errorMessage;

    @Schema(
            description = "Time the error occured."
    )
    private LocalDateTime errorTime;

}
