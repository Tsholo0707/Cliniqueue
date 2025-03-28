/*PatientFactory.java
Patient model Factory class
Author: Tsholofelo Mabidikane (230018165)
Date: 23 March 2025
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Patient;
import za.ac.cput.util.Helper;
import java.time.LocalDate;



public class PatientFactory {

    public static Patient createPatient(String patientFirstName, String patientLastName, String patientGender,
                                        String patientPhoneNumber, LocalDate patientDateOfBirth, String patientAddress,
                                        String patientBloodType, String emergencyContact) {

        if(Helper.isNullOrEmpty(patientFirstName) || Helper.isNullOrEmpty(patientLastName))
            return null;

        if(Helper.isNullOrEmpty(patientGender))
            return null;

        if(Helper.isValidPhoneNumber(patientPhoneNumber))
            return null;

        if(Helper.isValidDateOfBirth(patientDateOfBirth))
            return null;

        if(Helper.isNullOrEmpty(patientAddress) || Helper.isNullOrEmpty(patientBloodType))
            return null;

        if(Helper.isNullOrEmpty(emergencyContact))
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
