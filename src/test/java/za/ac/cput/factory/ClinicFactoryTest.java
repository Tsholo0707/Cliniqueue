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
        Clinic clinic = ClinicFactory.createClinic("C0051", "Beauty of Life Clinic", "8001 Woodstork, Main Rd Cape Town", "0212275841");
        assertNotNull(clinic, "Clinic should be created successfully with valid data");
        System.out.println("Created Clinic: " + clinic);
    }

    @Test
    @Order(2)
    void testCreateClinicWithInvalidPhoneNumber() {
        Clinic clinic = ClinicFactory.createClinic("C0097", "WalkSmith Clinic", "77, Observatory, Small Street", "062234");
        assertNull(clinic, "Clinic with an invalid phone number should not be created");
        System.out.println("Failed Clinic Creation: " + clinic);
    }

    @Test
    @Order(3)
    void testCreateClinicWithEmptyName() {
        Clinic clinic = ClinicFactory.createClinic("C0031", "", "145 Nonhle Street, Durban", "03126538");
        assertNull(clinic, "Clinic with an empty name should not be created");
        System.out.println("Failed Clinic Creation: " + clinic);
    }

    @Test
    @Order(4)
    void testCreateClinicWithEmptyAddress() {
        Clinic clinic = ClinicFactory.createClinic("C0022", "Life Care Clinic", "", "021752908");
        assertNull(clinic, "Clinic with an empty address should not be created");
        System.out.println("Failed Clinic Creation: " + clinic);
    }
}
