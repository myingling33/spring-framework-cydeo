package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity {

    private String email;
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY) // won't retrieve account object until asked for.
    @JoinColumn(name = "account_details_id") // change foreign key name
    private Account account;   // account_id

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
