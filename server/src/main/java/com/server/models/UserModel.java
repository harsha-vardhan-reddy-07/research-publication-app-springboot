package com.server.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "users")
public class UserModel {

    public String _id;
    public String username;
    public String email;
    public String password;
    public String usertype;
    public String domain;
    public String qualification;


    public UserModel(){}

    public String get_id() {
        return _id;
    }
    
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "UserModel [_id=" + _id + ", domain=" + domain + ", email=" + email + ", password=" + password
                + ", qualification=" + qualification + ", username=" + username + ", usertype=" + usertype + "]";
    }
    
}
