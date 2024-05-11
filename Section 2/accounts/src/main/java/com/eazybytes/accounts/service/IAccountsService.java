package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     * To update account
     * @param customerDto
     * @return
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     * Delete account
     * @param mobileNumber
     * @return
     */
    boolean deleteAccount(String mobileNumber);

}
