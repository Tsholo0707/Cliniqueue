/*PatientFactoryTest.java
Patient FactoryTest class
Author: Tsholofelo Mabidikane (230018165)
Date: 27 March 2025
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PatientFactoryTest {

    private static Patient validPatient = PatientFactory.createPatient("Greg", "Matthews", "Male", "0712356879",
            LocalDate.of(1995, 5, 15), "254 Main St, Cityville", "A+", "0635786932");

    private static Patient patientWithNullFirstName = PatientFactory.createPatient("", "Van Der Merwe", "Male", "0714567890",
            LocalDate.of(2000, 3, 20), "132 Pluto St, Sunnyside", "O+", "0829876543");

    private static Patient patientWithFutureDOB = PatientFactory.createPatient("Fhatima", "Shivandri", "Female", "0612347687",
            LocalDate.of(2030, 1, 1), "346 Tambotie St, Lansia", "B+", "0738765342");

    private static Patient patientWithInvalidPhone = PatientFactory.createPatient("Ethan", "Pietersen", "Male", "1234",
            LocalDate.of(2005, 8, 25), "34 Riveria St, GreenPark", "O+", "0795678901");

    private static Patient patientWithNullEmergencyContact = PatientFactory.createPatient("Thandi", "Mokoena", "Female", "0682103645",
            LocalDate.of(1985, 11, 8), "55 Dube St, Orlando", "A+", "null");

    @Test
    @Order(1)
    public void testCreateValidPatient() {
        assertNotNull(validPatient, "Patient should be created successfully with valid data");
        System.out.println("Created patient: " + validPatient);
    }

    @Test
    @Order(2)
    public void testCreatePatientWithNullFirstName() {
        assertNull(patientWithNullFirstName, "Patient with null first name should not be created");
        System.out.println("Failed patient creation with null first name: " + patientWithNullFirstName);
    }

    @Test
    @Order(3)
    public void testCreatePatientWithFutureDOB() {
        assertNull(patientWithFutureDOB, "Patient with future DOB should not be created");
        System.out.println("Failed patient creation with future DOB: " + patientWithFutureDOB);
    }

    @Test
    @Order(4)
    public void testCreatePatientInvalidPhoneNumber() {
        assertNull(patientWithInvalidPhone, "Patient with invalid phone number should not be created");
        System.out.println("Failed patient creation with invalid phone number: " + patientWithInvalidPhone);
    }

    @Test
    @Order(5)
    public void testCreatePatientWithNullEmergencyContact() {
        assertNotNull(patientWithNullEmergencyContact, "Patient with null emergency contact should still be created");
        System.out.println("Created patient with null emergency contact: " + patientWithNullEmergencyContact);
    }
}