package com.nourtabib.app.commandservice.Entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@Builder
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public UserEntity(){

    }
    public UserEntity(Long id,String firstName,String lastName,String username,String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public UserEntity(String firstName,String lastName,String username,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
