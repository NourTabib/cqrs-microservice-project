package com.nourtabib.app.commandservice.Requests;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class updateUserRequest {
    private Long id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    public updateUserRequest() {
    }

    public updateUserRequest(Long id, String username, String password, String lastName, String firstName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
