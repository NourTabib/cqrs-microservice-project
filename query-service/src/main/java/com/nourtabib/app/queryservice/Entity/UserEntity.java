package com.nourtabib.app.queryservice.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class UserEntity {
    @Id
    private String _id ;
    @Indexed(unique = true)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserEntity() {
    }

    public UserEntity(String _id, Long id, String username, String password, String firstName, String lastName) {
        this._id = _id;
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserEntity(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String get_id() {
        return _id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        return "_id:"+ this.get_id() +
                ",id:" + this.getId().toString() +
                ",username:" + this.getUsername() +
                ",password:" +this.getPassword() +
                ",firstName:"+this.getFirstName() +
                ",lastName:"+ this.getLastName()  ;
    }
}
