/*
Admin.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 22/03/2025
 */

package za.ac.cput.domain;

import java.time.LocalDateTime;


public class Admin extends User {

    private LocalDateTime lastLogin;
    private String status;

    protected Admin(Builder builder) {
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

        public Builder copy(Admin admin) {
            super.copy(admin);
            this.lastLogin = admin.getLastLogin();
            this.status = admin.getStatus();
            return this;
        }

        @Override
        public Admin build() {
            return new Admin(this);
        }
    }
}
