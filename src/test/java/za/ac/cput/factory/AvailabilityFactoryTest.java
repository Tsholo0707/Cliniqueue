package za.ac.cput.factory.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Availability;
import za.ac.cput.domain.Doctor;
import za.ac.cput.factory.AvailabilityFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AvailabilityFactoryTest {

    private static Availability validAvailability;
    private static Availability invalidAvailabilityDate;

    private static Doctor doctor = new Doctor.Builder()
            .setDoctorId("D001")
            .setDoctorFirstName("John")
            .setDoctorLastName("Doe")
            .setDoctorSpecialization("Cardiologist")
            .build();

    @BeforeAll
    static void setup() {
        validAvailability = AvailabilityFactory.createAvailability(doctor, LocalDateTime.of(2025, 3, 30, 10, 0), true);
        invalidAvailabilityDate = AvailabilityFactory.createAvailability(doctor, null, true);
    }

    @Test
    @Order(1)
    public void testCreateAvailabilityWithValidData() {
        System.out.println("Test: testCreateAvailabilityWithValidData");
        assertNotNull(validAvailability, "Availability should be created successfully with valid data");
        System.out.println("Created availability: " + validAvailability);
    }

    @Test
    @Order(2)
    public void testCreateAvailabilityWithInvalidDate() {
        System.out.println("Test: testCreateAvailabilityWithInvalidDate");
        assertNull(invalidAvailabilityDate, "Availability with invalid date should not be created");
        System.out.println("Failed availability creation with invalid date: " + invalidAvailabilityDate);
    }
}
