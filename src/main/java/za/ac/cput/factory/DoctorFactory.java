/*
DoctorFactory.java
Doctor model Factory class
Author: Samkelisiwe Sithabile Khanyile
Date: 27 March 2025
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;

public class DoctorFactory {

    public static Doctor createDoctor(String doctorId, String firstName, String lastName, String specialization, String phoneNumber, String email) {
        if (Helper.isNullOrEmpty(doctorId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(specialization))
            return null;

        if (!Helper.isValidPhoneNumber(phoneNumber))
            return null;

        if (!Helper.isValidEmail(email))
            return null;

        return new Doctor.Builder()
                .setDoctorId(doctorId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setSpecialization(specialization) // Ensure this method exists in Doctor.Builder
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .build();
    }
    }