/*
 * ClinicRepositoryTest.java
 * Test class for ClinicRepository
 * Author: Samkelisiwe Sithabile Khanyile
 * Date: 27 March 2025
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Clinic;
import za.ac.cput.factory.ClinicFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClinicRepositoryTest {

    private static IClinicRepository repository = ClinicRepository.getRepository();
    private static Clinic clinic = ClinicFactory.createClinic("C0051", "Beauty of Life Clinic", "8001 Woodstork, Main Rd Cape Town", "0212275841");

    @Test
    @Order(1)
    void a_create() {
        Clinic created = repository.create(clinic);
        assertNotNull(created);
        System.out.println("Created Clinic: " + created);
    }

    @Test
    @Order(2)
    void b_read() {
        Clinic read = repository.read(clinic.getClinicId());
        assertNotNull(read);
        System.out.println("Read Clinic: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Clinic updatedClinic = new Clinic.Builder().copy(clinic).setClinicName("New Beauty of Life Clinic").build();
        Clinic updated = repository.update(updatedClinic);
        assertNotNull(updated);
        System.out.println("Updated Clinic: " + updated);
    }

    @Test
    @Order(4)
    void d_delete() {
        boolean success = repository.delete(clinic.getClinicId());
        assertTrue(success);
        System.out.println("Clinic successfully deleted");
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println("All Clinics: " + repository.getAll());
    }
}
