/*PatientFactory.java
Patient model Factory class
Author: Tsholofelo Mabidikane (230018165)
Date: 23 March 2025
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Patient;
import za.ac.cput.util.ReportHelper;
import java.util.Date;

public class PatientFactory {

    public static Patient createPatient(String patientFirstName, String patientLastName, String patientGender,
                                        String patientPhoneNumber, Date patientDateOfBirth,String patientAddress,
                                        String patientBloodType,String emergencyContact) {

        if(ReportHelper.isNullOrEmpty(patientFirstName) || ReportHelper.isNullOrEmpty(patientLastName))
            return null;

        if(ReportHelper.isNullOrEmpty(patientGender))
            return null;

        if(ReportHelper.isValidPhoneNumber(patientPhoneNumber))
            return null;

        if(ReportHelper.isValidDateOfBirth(patientDateOfBirth))
            return null;

        if(ReportHelper.isNullOrEmpty(patientAddress) || ReportHelper.isNullOrEmpty(patientBloodType))
            return null;

        if(ReportHelper.isNullOrEmpty(emergencyContact))
            return null;

        return new Patient.Builder()
                .setPatientFirstName(patientFirstName)
                .setPatientLastName(patientLastName)
                .setPatientGender(patientGender)
                .setPatientPhoneNumber(patientPhoneNumber)
                .setPatientDateOfBirth(patientDateOfBirth)
                .setPatientAddress(patientAddress)
                .setPatientBloodType(patientBloodType)
                .setEmergencyContact(emergencyContact)
                .build();
    }
}
