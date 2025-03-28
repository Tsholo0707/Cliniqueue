/* AdminFactory.java
Author: Agnes Mabusela (230020690)
Date: 25/03/2025
 */
package za.ac.cput.factory;


import za.ac.cput.domain.Admin;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class AdminFactory {

    public static Admin createAdmin(String userIdentityNumber, String userFirstName, String userMiddleName,
                                    String userLastName, String userPhoneNumber,
                                    String userEmail, String userPassword,
                                    String userRole, LocalDateTime lastLogin, String status) {


        User user = UserFactory.createUser(userIdentityNumber, userFirstName, userMiddleName,
                userLastName, userPhoneNumber, userEmail, userPassword, userRole);

        if (user == null) {
            return null;
        }

        if (!Helper.isValidLastLogin(lastLogin)) {
            return null;
        }

        if (!Helper.isValidStatus(status)) {
            return null;
        }

        return new Admin.Builder().copy(user)
                .setLastLogin(lastLogin)
                .setStatus(status)
                .build();
    }
}
