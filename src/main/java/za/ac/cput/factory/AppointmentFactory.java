package za.ac.cput.factory;

import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Doctor;
import za.ac.cput.domain.Patient;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

/**
 * Class: AppointmentFactory
 * Author: Sisanda Madikizela
 * Date: March 25, 2025,
 * Description: Factory class for creating Appointment objects with validations.
 */

public class AppointmentFactory {

    public static Appointment createAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime, String status) {
        // Validate Doctor, Patient, DateTime, and Status
        if (doctor == null || patient == null || !Helper.isValidAppointment(dateTime, status)) {
            return null; // Return null if invalid
        }

        // Return new Appointment object if inputs are valid
        return new Appointment.Builder()
                .setDoctor(doctor)
                .setPatient(patient)
                .setDateTime(dateTime)
                .setStatus(status)
                .build();
    }
}
