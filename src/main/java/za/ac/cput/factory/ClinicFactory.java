package za.ac.cput.factory;

import za.ac.cput.domain.Clinic;
import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;

import java.util.List;

/**
 * Factory class for creating Clinic objects.
 * Author: Samkelisiwe Khanyile (222843152)
 * Date: 21/03/2025
 */
public class ClinicFactory {


    public static Clinic createClinic(String clinicId, String clinicName,
                                      String clinicAddress, String clinicPhoneNumber,
                                      List<Doctor> doctors) {

        // Validate inputs
        if (Helper.isNullOrEmpty(clinicName) || Helper.isNullOrEmpty(clinicAddress)) {
            return null; // Invalid name or address
        }

        if (!Helper.isValidPhoneNumber(clinicPhoneNumber)) {
            return null; // Invalid phone number
        }

        // Build and return the Clinic instance
        return new Clinic.Builder()
                .setClinicId(clinicId)
                .setClinicName(clinicName)
                .setClinicAddress(clinicAddress)
                .setClinicPhoneNumber(clinicPhoneNumber)
                .setDoctors(doctors)
                .build();
    }
}
