package za.ac.cput.factory;

import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;

/**
 * Factory class for creating Doctor objects.
 * Author: Samkelisiwe Khanyile (222843152)
 * Date: 21/03/2025
 */
public class DoctorFactory {


    public static Doctor createDoctor(String doctorId, String firstName,
                                      String lastName, String specialization,
                                      String phoneNumber) {

        // Validate inputs
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(specialization)) {
            return null; // Invalid first name, last name, or specialization
        }

        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            return null; // Invalid phone number
        }

        // Build and return the Doctor instance
        return new Doctor.Builder()
                .setDoctorId(doctorId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setSpecialization(specialization)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}