package za.ac.cput.factory;

import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;

public class DoctorFactory {

    public static Doctor createDoctor(String doctorId, String firstName, String lastName,
                                      String specialization, String phoneNumber,
                                      String email) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
            return null;

        if (!Helper.isValidEmail(email))
            return null;

        if (!Helper.isValidPhoneNumber(phoneNumber))
            return null;

        return new Doctor.Builder()
                .setDoctorId(doctorId)
                .setDoctorFirstName(firstName)
                .setDoctorLastName(lastName)
                .setDoctorSpecialization(specialization)
                .setDoctorPhoneNumber(phoneNumber)
                .setDoctorEmail(email)
                .build();
    }
}
