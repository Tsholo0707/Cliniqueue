/*
 * DoctorFactoryTest.java
 * Test class for DoctorFactory
 * Author: Samkelisiwe Sithabile Khanyile
 * Date: 27 March 2025
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Doctor;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoctorFactoryTest {

    @Test
    @Order(1)
    void testCreateDoctorWithValidData() {
        Doctor doctor = DoctorFactory.createDoctor("D001", "John", "Doe", "Cardiologist", "092686464321", "johndoe001@gmail.com");
        assertNotNull(doctor, "Doctor should be created successfully with valid data");
        System.out.println("Created Doctor: " + doctor);
    }

    @Test
    @Order(2)
    void testCreateDoctorWithInvalidEmail() {
        Doctor doctor = DoctorFactory.createDoctor("D002", "Jane", "Smith", "Dermatologist", "0711384620", "janesmithgmail.com");
        assertNull(doctor, "Doctor with an invalid email should not be created");
        System.out.println("Failed Doctor Creation: " + doctor);
    }

    @Test
    @Order(3)
    void testCreateDoctorWithEmptyFirstName() {
        Doctor doctor = DoctorFactory.createDoctor("D003", "", "Brown", "Neurologist", "0765432198", "browndoctor@example.com");
        assertNull(doctor, "Doctor with an empty first name should not be created");
        System.out.println("Failed Doctor Creation: " + doctor);
    }

    @Test
    @Order(4)
    void testCreateDoctorWithInvalidPhoneNumber() {
        Doctor doctor = DoctorFactory.createDoctor("D0011", "Michael", "Adams", "Pediatrician", "1307", "madams12@gmail.com");
        assertNull(doctor, "Doctor with an invalid phone number should not be created");
        System.out.println("Failed Doctor Creation: " + doctor);
    }
}
