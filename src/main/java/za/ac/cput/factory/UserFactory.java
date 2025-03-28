/*
UserFactory.java
User model Factory class
Author: Agnes Mabusela (230020690)
Date: 21/03/2025
 */


package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User createUser(String userIdentityNumber, String userFirstName, String userMiddleName,
                                  String userLastName, String userPhoneNumber,
                                  String userEmail, String userPassword,
                                  String userRole){

        if(Helper.isNullOrEmpty(userFirstName) || Helper.isNullOrEmpty(userLastName))
            return null;

        if (!Helper.isValidEmail(userEmail))
            return null;

        if(!Helper.isValidPassword(userPassword))
            return null;

        if(!Helper.isIdentityNumber(userIdentityNumber))
            return null;

        if(!Helper.isValidPhoneNumber(userPhoneNumber))
            return null;

        return new User.Builder()
                .setUserIdentityNumber(userIdentityNumber)
                .setUserFirstName(userFirstName)
                .setUserMiddleName(userMiddleName) // can be null or empty
                .setUserLastName(userLastName)
                .setUserPhoneNumber(userPhoneNumber)
                .setUserEmail(userEmail)
                .setUserPassword(userPassword)
                .setUserRole(userRole)
                .build();
    }

}
