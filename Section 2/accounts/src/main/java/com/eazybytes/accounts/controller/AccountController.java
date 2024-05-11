package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constant.AccountsConstant;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "CRUD Rest API for Accounts Eazybank",
        description = "CRUD Rest API for Eazybank: CREATE, UPDATE, DELETE"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE}) //pre-path
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final IAccountsService accountsService;

    @Operation(
            summary = "Create operation using HTTP Post method.",
            description = "Create new customer for eazybank."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http Status created. New Customer created."
            ),
            @ApiResponse(
                    description = "Customer update failed, internal server error.",
                    responseCode = "500",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstant.STATUS_201, AccountsConstant.MESSAGE_201));
    }

    @Operation(
            summary = "Read operation using HTTP Get method.",
            description = "Search for a customer by mobile number."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status OK. Customer Found."
            ),
            @ApiResponse(
                    description = "Customer update failed, internal server error.",
                    responseCode = "500",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                           @Pattern(regexp = "5\\d{7}", message = "Mobile number should start by 5 and followed by 7 digits")
                                                           String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(
            summary = "Update operation using HTTP Put method.",
            description = "Update customer for eazybank."
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Customer updated successfully.",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Expectation Failed.",
                    responseCode = "417"
            ),
            @ApiResponse(
                    description = "Customer update failed, internal server error.",
                    responseCode = "500",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstant.STATUS_417, AccountsConstant.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete operation using HTTP Delete method.",
            description = "Delete customer for eazybank."
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Customer deleted successfully.",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Expectation Failed.",
                    responseCode = "417"
            ),
            @ApiResponse(
                    description = "Customer deletion failed, internal server error.",
                    responseCode = "500"
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetail(@RequestParam
                                                           @Pattern(regexp = "5\\d{7}", message = "Mobile number should start by 5 and followed by 7 digits")
                                                           String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstant.STATUS_417, AccountsConstant.MESSAGE_417_DELETE));
        }
    }
}
