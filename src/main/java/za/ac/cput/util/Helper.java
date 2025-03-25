/* User.java
User model Factory Helper Class
Author: Agnes Mabusela (230020690)
Date: 21/03/2025
 */
package za.ac.cput.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.time.LocalDateTime;

public class Helper {

    public static boolean isNullOrEmpty(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isIdentityNumber(String identityNumber) {
        if(isNullOrEmpty(identityNumber) || identityNumber.length() !=13) {
            return false;
        }
        //ID number should be 13 digits long
        String regex ="^[0-9]{13}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(identityNumber);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email){
        if(isNullOrEmpty(email)) {
            return false;
        }
        String regex ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password){
        if(isNullOrEmpty(password)){
            return false;
        }
        //Checks if Password has at least one digit, one letter and is more than 8 characters long
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (isNullOrEmpty(phoneNumber)) {
            return false;
        }

        //Checks for e.g 0725637252 or +27 72 563...
        String regex = "^(\\+27|0)[6-8][0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    // Validation for Availability
    public static boolean isValidAvailability(LocalDateTime dateTime) {
        return dateTime != null && dateTime.isAfter(LocalDateTime.now());
    }

    // Validation for Appointments
    public static boolean isValidAppointment(LocalDateTime dateTime, String status) {
        return dateTime != null && dateTime.isAfter(LocalDateTime.now()) &&
                (status.equalsIgnoreCase("Scheduled") ||
                        status.equalsIgnoreCase("Completed") ||
                        status.equalsIgnoreCase("Cancelled"));
    }
       // Validation for Generic Date-Time
       public static boolean isValidDateTime(LocalDateTime dateTime) {
             return dateTime != null && dateTime.isAfter(LocalDateTime.now());
    }


}