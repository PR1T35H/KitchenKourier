package com.example.kitchenkourier.Domain;

public class ProfileDomain {

    String userId;
    String userName;
    String userNumnber;


    public ProfileDomain(){

    }

    public ProfileDomain(String userId, String userName, String userNumnber) {
        this.userId = userId;
        this.userName = userName;
        this.userNumnber = userNumnber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNumnber() {
        return userNumnber;
    }
}
