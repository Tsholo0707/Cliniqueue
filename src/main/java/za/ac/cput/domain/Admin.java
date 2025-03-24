/* Admin.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 22/03/2025
 */

package za.ac.cput.domain;

import java.time.LocalDateTime;


public class Admin extends User {

    private LocalDateTime lastLogin;
    private String status;

    private Admin(Builder builder) {
        super(builder);
        this.lastLogin = builder.lastLogin;
        this.status = builder.status;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Admin{" +
                "lastLogin=" + lastLogin +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder extends User.Builder {
        private LocalDateTime lastLogin;
        private String status;

        public Builder setLastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        @Override
        public Builder setUserIdentityNumber(String userIdentityNumber) {
            super.setUserIdentityNumber(userIdentityNumber);
            return this;
        }

        @Override
        public Builder setUserFirstName(String userFirstName) {
            super.setUserFirstName(userFirstName);
            return this;
        }

        @Override
        public Builder setUserMiddleName(String userMiddleName) {
            super.setUserMiddleName(userMiddleName);
            return this;
        }

        @Override
        public Builder setUserLastName(String userLastName) {
            super.setUserLastName(userLastName);
            return this;
        }

        @Override
        public Builder setUserPhoneNumber(String userPhoneNumber) {
            super.setUserPhoneNumber(userPhoneNumber);
            return this;
        }

        @Override
        public Builder setUserEmail(String userEmail) {
            super.setUserEmail(userEmail);
            return this;
        }

        @Override
        public Builder setUserPassword(String userPassword) {
            super.setUserPassword(userPassword);
            return this;
        }

        @Override
        public Builder setUserRole(String userRole) {
            super.setUserRole(userRole);
            return this;
        }

        public Builder copy(Admin admin) {
            super.copy(admin);
            this.lastLogin = admin.getLastLogin();
            this.status = admin.getStatus();
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
