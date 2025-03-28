package za.ac.cput.factory;

import za.ac.cput.domain.Availability;
import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

/**
 * Class: AvailabilityFactory
 * Author: Sisanda Madikizela
 * Date: March 25, 2025,
 * Description: Factory class for creating Availability objects with validations.
 */


public class AvailabilityFactory {

    public static Availability createAvailability(Doctor doctor, LocalDateTime dateTime, boolean isAvailable) {
        // Validate Doctor and DateTime (using your helper methods)
        if (doctor == null || !Helper.isValidAvailability(dateTime)) {
            return null; // Return null if invalid
        }

        // Return new Availability object if inputs are valid
        return new Availability.Builder()
                .setDoctor(doctor)
                .setDateTime(dateTime)
                .setIsAvailable(isAvailable)
                .build();
    }
}
