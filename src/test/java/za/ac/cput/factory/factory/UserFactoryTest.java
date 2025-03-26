/* UserFactoryTest.java
Admin model class
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */

package za.ac.cput.factory.factory;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserFactoryTest {

    private static User userWithGoodData = UserFactory.createUser("6407212827080",
            "Madikila", "Agnes", "Mabusela",
            "0716726718","Agnesmabusela123@gmail.com",
            "Password123", "Admin");

    private static User userWithNullMiddleName = UserFactory.createUser("6407212827080",
            "Madikila", null, "Mabusela",
            "0716726718","Agnesmabusela123@gmail.com",
            "Password123", "Admin");
    private static User userWithBadEmail = UserFactory.createUser("6407212827080",
            "Madikila", "Agnes", "Mabusela",
            "0716726718","Agnesmabusela123gmail.com",
            "Password123", "Admin");

    private static User userWithBadIdentityNumber = UserFactory.createUser("627080",
            "Madikila", "Agnes", "Mabusela",
            "0716726718","Agnesmabusela123@gmail.com",
            "Password123", "Admin");

    private static User userWithBadPhoneNumber = UserFactory.createUser("6407212827080",
            "Madikila", "Agnes", "Mabusela",
            "1509206726718","Agnesmabusela123@gmail.com",
            "Password123", "Admin");
    private static User userWithBadPassword= UserFactory.createUser("6407212827080",
            "Madikila", "Agnes", "Mabusela",
            "0716726718","Agnesmabusela123@gmail.com",
            "Banana", "Admin");


    @Test
    @Order(1)
    public void testCreateUserWithValidData() {
        System.out.println("Test: testCreateUserWithValidData");
        assertNotNull(userWithGoodData, "User should be created successfully with valid data");
        System.out.println("Created user: " + userWithGoodData);
    }

    @Test
    @Order(2)
    public void testCreateUserWithInvalidIdentityNumber() {
        System.out.println("Test: testCreateUserWithInvalidIdentityNumber");
        assertNull(userWithBadIdentityNumber, "User with invalid identity number should not be created");
        System.out.println("Failed user creation with invalid identity number: " + userWithBadIdentityNumber);
    }

    @Test
    @Order(3)
    public void testCreateUserWithNullMiddleName() {
        System.out.println("Test: testCreateUserWithNullMiddleName");
        assertNotNull(userWithNullMiddleName, "User with null middle name should still be created");
        System.out.println("Created user with null middle name: " + userWithNullMiddleName);
    }


    @Test
    @Order(4)
    public void testCreateUserWithInvalidEmail() {
        System.out.println("Test: testCreateUserWithInvalidEmail");
        assertNull(userWithBadEmail, "User with invalid email should not be created");
        System.out.println("Failed user creation with invalid email: " + userWithBadEmail);
    }

    @Test
    @Order(5)
    public void testCreateUserWithInvalidPhoneNumber() {
        System.out.println("Test: testCreateUserWithInvalidPhoneNumber");
        assertNull(userWithBadPhoneNumber, "User with invalid phone number should not be created");
        System.out.println("Failed user creation with invalid phone number: " + userWithBadPhoneNumber);
    }

    @Test
    @Order(6)
    public void testCreateUserWithInvalidPassword() {
        System.out.println("Test: testCreateUserWithInvalidPassword");
        assertNull(userWithBadPassword, "User with invalid password should not be created");
        System.out.println("Failed user creation with invalid password: " + userWithBadPassword);
    }
    @Test
    @Order(7)
    public void testCreateUserThatFails() {
        System.out.println("Test: testCreateUserThatFails");
        assertNull(userWithBadEmail, "User with an invalid email address should not be created");
        System.out.println("Failed user creation with invalid email: " + userWithBadEmail);
    }
}