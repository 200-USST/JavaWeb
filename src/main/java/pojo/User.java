package pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String userName;
    private String userPassword;
    private String userIdentity;
    private String userGender;
    private String userAge;

    public User() {
    }

    public User(String id, String userName, String userPassword, String userIdentity, String userGender, String userAge) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userIdentity = userIdentity;
        this.userGender = userGender;
        this.userAge = userAge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
}
