package com.nourtabib.app.commandservice.Requests;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class createUserRequest {
    private String username;
    private String password;
    private String lastName;
    private String firstName;


    public createUserRequest(String username, String password, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public createUserRequest() {
    }
}
