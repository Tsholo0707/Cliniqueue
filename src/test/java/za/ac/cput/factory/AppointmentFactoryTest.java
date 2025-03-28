package za.ac.cput.factory.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Doctor;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.domain.Availability;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentFactoryTest {

    private static Appointment validAppointment;
    private static Appointment invalidAppointmentDoctorNotAvailable;

    private static Doctor doctor = new Doctor.Builder()
            .setDoctorId("D001")
            .setDoctorFirstName("John")
            .setDoctorLastName("Doe")
            .setDoctorSpecialization("Cardiologist")
            .build();

    private static Availability validAvailability = new Availability.Builder()
            .setDoctor(doctor)
            .setDateTime(LocalDateTime.of(2025, 3, 30, 10, 0))
            .setIsAvailable(true)
            .build();

    private static Availability invalidAvailability = new Availability.Builder()
            .setDoctor(doctor)
            .setDateTime(LocalDateTime.of(2025, 3, 30, 12, 0))
            .setIsAvailable(false)
            .build();

    @BeforeAll
    static void setup() {
        validAppointment = AppointmentFactory.createAppointment(doctor, validAvailability.getDateTime(), "Routine Checkup");
        invalidAppointmentDoctorNotAvailable = AppointmentFactory.createAppointment(doctor, invalidAvailability.getDateTime(), "Emergency");
    }

    @Test
    @Order(1)
    public void testCreateAppointmentWithValidData() {
        System.out.println("Test: testCreateAppointmentWithValidData");
        assertNotNull(validAppointment, "Appointment should be created successfully with valid data");
        System.out.println("Created appointment: " + validAppointment);
    }

    @Test
    @Order(2)
    public void testCreateAppointmentWhenDoctorIsNotAvailable() {
        System.out.println("Test: testCreateAppointmentWhenDoctorIsNotAvailable");
        assertNull(invalidAppointmentDoctorNotAvailable, "Appointment should not be created if doctor is not available");
        System.out.println("Failed appointment creation when doctor is unavailable: " + invalidAppointmentDoctorNotAvailable);
    }
}
