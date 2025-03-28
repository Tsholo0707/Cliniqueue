package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Availability;
import za.ac.cput.domain.Doctor;
import za.ac.cput.factory.AvailabilityFactory;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AvailabilityRepositoryTest {

    private static IAvailabilityRepository repository = AvailabilityRepository.getRepository();
    private static Availability availability1, availability2, availability3;
    private static Doctor doctor;

    @BeforeAll
    static void setup() {
        doctor = new Doctor.Builder()
                .setDoctorId("D001")
                .setDoctorFirstName("John")
                .setDoctorLastName("Doe")
                .setDoctorSpecialization("Cardiologist")
                .build();

        availability1 = AvailabilityFactory.createAvailability(doctor, LocalDateTime.of(2025, 3, 30, 10, 0), true);
        availability2 = AvailabilityFactory.createAvailability(doctor, LocalDateTime.of(2025, 3, 30, 14, 0), true);
        availability3 = AvailabilityFactory.createAvailability(doctor, LocalDateTime.of(2025, 3, 31, 9, 0), false);
    }

    @Test
    @Order(1)
    void a_create() {
        assertNotNull(repository.create(availability1));
        assertNotNull(repository.create(availability2));
        assertNotNull(repository.create(availability3));
        System.out.println("Availabilities Created: \n" + repository.getAll());
    }

    @Test
    @Order(2)
    void b_read() {
        Availability readAvailability = repository.read(availability1.getDateTime());
        assertNotNull(readAvailability);
        System.out.println("Read Availability: " + readAvailability);
    }

    @Test
    @Order(3)
    void c_update() {
        Availability updatedAvailability = new Availability.Builder()
                .copy(availability1)
                .setIsAvailable(false)
                .build();

        Availability result = repository.update(updatedAvailability);
        assertNotNull(result);
        System.out.println("Updated Availability: " + result);
    }

    @Test
    @Order(4)
    void d_delete() {
        assertTrue(repository.delete(availability2.getDateTime()));
        System.out.println("Deleted Availability with Date: " + availability2.getDateTime());
    }

    @Test
    @Order(5)
    void e_getAll() {
        Set<Availability> availabilities = repository.getAll();
        assertFalse(availabilities.isEmpty());
        System.out.println("All Availabilities: \n" + availabilities);
    }
}
