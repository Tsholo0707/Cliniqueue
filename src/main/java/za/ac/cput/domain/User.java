/*
User.java
User model class
Author: Agnes Mabusela (230020690)
Date: 21/03/2025
 */


package za.ac.cput.domain;

public class User {

    private String userIdentityNumber;
    private String userFirstName;
    private String userMiddleName;//Optional
    private String userLastName;
    private String userPhoneNumber;
    private String userEmail;
    private String userPassword;
    private String userRole;

    protected User(){

    }

    protected User(Builder builder){
        this.userIdentityNumber = builder.userIdentityNumber;
        this.userFirstName = builder.userFirstName;
        this.userMiddleName = builder.userMiddleName;
        this.userLastName = builder.userLastName;
        this.userPhoneNumber = builder.userPhoneNumber;
        this.userEmail = builder.userEmail;
        this.userPassword = builder.userPassword;
        this.userRole = builder.userRole;
    }

    public User(Admin.Builder builder) {
    }

    public String getUserIdentityNumber() {
        return userIdentityNumber;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userIdentityNumber +
                ", userFirstName='" + userFirstName + '\'' +
                ", userMiddleName='" + userMiddleName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

    public static class Builder{

        private String userIdentityNumber;
        private String userFirstName;
        private String userMiddleName;
        private String userLastName;
        private String userPhoneNumber;
        private String userEmail;
        private String userPassword;
        private String userRole;

        public Builder setUserIdentityNumber(String userIdentityNumber) {
            this.userIdentityNumber = userIdentityNumber;
            return this;
        }
        public Builder setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
            return this;
        }

        public Builder setUserMiddleName(String userMiddleName) {
            this.userMiddleName = userMiddleName;
            return this;
        }

        public Builder setUserLastName(String userLastName) {
            this.userLastName = userLastName;
            return this;
        }

        public Builder setUserPhoneNumber(String userPhoneNumber) {
            this.userPhoneNumber = userPhoneNumber;
            return this;
        }

        public Builder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public Builder setUserRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder copy(User user){
            this.userIdentityNumber = user.getUserIdentityNumber();
            this.userFirstName = user.getUserFirstName();
            this.userMiddleName = user.getUserMiddleName();
            this.userLastName = user.getUserLastName();
            this.userPhoneNumber = user.getUserPhoneNumber();
            this.userEmail = user.getUserEmail();
            this.userPassword = user.getUserPassword();
            this.userRole = user.getUserRole();
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
