package za.ac.cput.factory.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.factory.NotificationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationFactoryTest {

    private static User sender = new User("1001", "Alice", "alice@example.com");
    private static User recipient = new User("1002", "Bob", "bob@example.com");

    private static Notification validNotification = NotificationFactory.createNotification(1, sender, recipient, "Your system will restart at midnight", "active");
    private static Notification notificationWithNullMessage = NotificationFactory.createNotification(2, sender, recipient, null, "active");
    private static Notification notificationWithEmptyId = NotificationFactory.createNotification(0, sender, recipient, "Scheduled system maintenance at 3 AM", "active");
    private static Notification notificationWithInvalidStatus = NotificationFactory.createNotification(3, sender, recipient, "Invalid status test", "unknown");
    private static Notification notificationWithNullSender = NotificationFactory.createNotification(4, null, recipient, "System update", "active");

    @Test
    @Order(1)
    public void testCreateNotificationWithValidData() {
        System.out.println("Test: testCreateNotificationWithValidData");
        assertNotNull(validNotification, "Notification should be created successfully with valid data");
        System.out.println("Created notification: " + validNotification);
    }

    @Test
    @Order(2)
    public void testCreateNotificationWithNullMessage() {
        System.out.println("Test: testCreateNotificationWithNullMessage");
        assertNull(notificationWithNullMessage, "Notification with null message should not be created");
    }

    @Test
    @Order(3)
    public void testCreateNotificationWithEmptyId() {
        System.out.println("Test: testCreateNotificationWithEmptyId");
        assertNull(notificationWithEmptyId, "Notification with empty ID should not be created");
    }

    @Test
    @Order(4)
    public void testCreateNotificationWithInvalidStatus() {
        System.out.println("Test: testCreateNotificationWithInvalidStatus");
        assertNull(notificationWithInvalidStatus, "Notification with an invalid status should not be created");
    }

    @Test
    @Order(5)
    public void testCreateNotificationWithNullSender() {
        System.out.println("Test: testCreateNotificationWithNullSender");
        assertNull(notificationWithNullSender, "Notification with a null sender should not be created");
    }
}
