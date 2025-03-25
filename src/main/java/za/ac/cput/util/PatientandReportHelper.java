/*ReportHelper.java
Report model Helper class
Author: Tsholofelo Mabidikane (230018165)
Date: 23 March 2025
 */
package za.ac.cput.util;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientandReportHelper {

    public static boolean isNullOrEmpty(String s) {
        if(s.isEmpty() || s == null)
            return true;
        return false;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if(isNullOrEmpty(phoneNumber)) {
            return false;
        }

        String regex = "^(\\+27|0)[6-8][0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isValidDateOfBirth(Date dateOfBirth) {
        if(dateOfBirth == null) {
            return false; // Invalid if null
        }
        Date today = new Date(); // Current date
        return !dateOfBirth.after(today); // Returns true if DOB is in the future (invalid)
    }
}
