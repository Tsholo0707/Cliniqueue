/*
 * DoctorRepositoryTest.java
 * Test class for DoctorRepository
 * Author: Samkelisiwe Sithabile Khanyile
 * Date: 27 March 2025
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Doctor;
import za.ac.cput.factory.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoctorRepositoryTest {

    private static IDoctorRepository repository = DoctorRepository.getRepository();
    private static Doctor doctor = DoctorFactory.createDoctor("D001", "John", "Doe", "Cardiologist", "092686464321", "johndoe001@gmail.com");

    @Test
    @Order(1)
    void a_create() {
        Doctor created = repository.create(doctor);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void b_read() {
        Doctor read = repository.read(doctor.getDoctorId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Doctor updatedDoctor = new Doctor.Builder().copy(doctor).setFirstName("Jonathan").build();
        Doctor updated = repository.update(updatedDoctor);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void d_delete() {
        boolean success = repository.delete(doctor.getDoctorId());
        assertTrue(success);
        System.out.println("Deleted successfully");
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println("All Doctors: " + repository.getAll());
    }
}
