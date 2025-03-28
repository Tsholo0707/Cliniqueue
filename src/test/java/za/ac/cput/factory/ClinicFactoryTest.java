/*
 * ClinicFactoryTest.java
 * Test class for ClinicFactory
 * Author: Samkelisiwe Sithabile Khanyile
 * Date: 27 March 2025
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Clinic;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClinicFactoryTest {

    @Test
    @Order(1)
    void testCreateClinicWithValidData() {
        Clinic clinic = ClinicFactory.createClinic("C123", "City Health Clinic", "123 Main Street, Cape Town", "0211234567");
        assertNotNull(clinic, "Clinic should be created successfully with valid data");
        System.out.println("Created Clinic: " + clinic);
    }

    @Test
    @Order(2)
    void testCreateClinicWithInvalidPhoneNumber() {
        Clinic clinic = ClinicFactory.createClinic("C456", "Greenwood Clinic", "45 Park Avenue, Johannesburg", "123");
        assertNull(clinic, "Clinic with an invalid phone number should not be created");
        System.out.println("Failed Clinic Creation: " + clinic);
    }

    @Test
    @Order(3)
    void testCreateClinicWithEmptyName() {
        Clinic clinic = ClinicFactory.createClinic("C789", "", "78 Rose Street, Durban", "0319876543");
        assertNull(clinic, "Clinic with an empty name should not be created");
        System.out.println("Failed Clinic Creation: " + clinic);
    }

    @Test
    @Order(4)
    void testCreateClinicWithEmptyAddress() {
        Clinic clinic = ClinicFactory.createClinic("C910", "Wellness Clinic", "", "0417654321");
        assertNull(clinic, "Clinic with an empty address should not be created");
        System.out.println("Failed Clinic Creation: " + clinic);
    }
}
