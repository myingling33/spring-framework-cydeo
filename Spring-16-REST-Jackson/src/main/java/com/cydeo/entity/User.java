package com.cydeo.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class User {

    private String email;

    private String password;

    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private Account account;
}
