/* UserFactoryTest.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Admin;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminFactoryTest {

    private static Admin adminWithGoodData = AdminFactory.createAdmin(
            "6407212827080", "Madikila", "Agnes", "Mabusela",
            "0716726718", "Agnesmabusela123@gmail.com",
            "Password123", "Admin", LocalDateTime.now(), "Active");

    private static Admin adminWithNullMiddleName = AdminFactory.createAdmin(
            "6407212827080", "Madikila", null, "Mabusela",
            "0716726718", "Agnesmabusela123@gmail.com",
            "Password123", "Admin", LocalDateTime.now(), "Active");

    private static Admin adminWithBadEmail = AdminFactory.createAdmin(
            "6407212827080", "Madikila", "Agnes", "Mabusela",
            "0716726718", "Agnesmabusela123gmail.com",
            "Password123", "Admin", LocalDateTime.now(), "Active");

    private static Admin adminWithBadIdentityNumber = AdminFactory.createAdmin(
            "627080", "Madikila", "Agnes", "Mabusela",
            "0716726718", "Agnesmabusela123@gmail.com",
            "Password123", "Admin", LocalDateTime.now(), "Active");

    private static Admin adminWithBadPhoneNumber = AdminFactory.createAdmin(
            "6407212827080", "Madikila", "Agnes", "Mabusela",
            "1509206726718", "Agnesmabusela123@gmail.com",
            "Password123", "Admin", LocalDateTime.now(), "Active");

    private static Admin adminWithBadPassword = AdminFactory.createAdmin(
            "6407212827080", "Madikila", "Agnes", "Mabusela",
            "0716726718", "Agnesmabusela123@gmail.com",
            "Banana", "Admin", LocalDateTime.now(), "Active");

    @Test
    @Order(1)
    public void testCreateAdminWithValidData() {
        System.out.println("Test: testCreateAdminWithValidData");
        assertNotNull(adminWithGoodData, "Admin should be created successfully with valid data");
        System.out.println("Created admin: " + adminWithGoodData);
    }

    @Test
    @Order(2)
    public void testCreateAdminWithInvalidIdentityNumber() {
        System.out.println("Test: testCreateAdminWithInvalidIdentityNumber");
        assertNull(adminWithBadIdentityNumber, "Admin with invalid identity number should not be created");
        System.out.println("Failed admin creation with invalid identity number: " + adminWithBadIdentityNumber);
    }

    @Test
    @Order(3)
    public void testCreateAdminWithNullMiddleName() {
        System.out.println("Test: testCreateAdminWithNullMiddleName");
        assertNotNull(adminWithNullMiddleName, "Admin with null middle name should still be created");
        System.out.println("Created admin with null middle name: " + adminWithNullMiddleName);
    }

    @Test
    @Order(4)
    public void testCreateAdminWithInvalidEmail() {
        System.out.println("Test: testCreateAdminWithInvalidEmail");
        assertNull(adminWithBadEmail, "Admin with invalid email should not be created");
        System.out.println("Failed admin creation with invalid email: " + adminWithBadEmail);
    }

    @Test
    @Order(5)
    public void testCreateAdminWithInvalidPhoneNumber() {
        System.out.println("Test: testCreateAdminWithInvalidPhoneNumber");
        assertNull(adminWithBadPhoneNumber, "Admin with invalid phone number should not be created");
        System.out.println("Failed admin creation with invalid phone number: " + adminWithBadPhoneNumber);
    }

    @Test
    @Order(6)
    public void testCreateAdminWithInvalidPassword() {
        System.out.println("Test: testCreateAdminWithInvalidPassword");
        assertNull(adminWithBadPassword, "Admin with invalid password should not be created");
        System.out.println("Failed admin creation with invalid password: " + adminWithBadPassword);
    }

    @Test
    @Order(7)
    public void testCreateAdminThatFails() {
        System.out.println("Test: testCreateAdminThatFails");
        assertNull(adminWithBadEmail, "Admin with an invalid email address should not be created");
        System.out.println("Failed admin creation with invalid email: " + adminWithBadEmail);
    }
}
