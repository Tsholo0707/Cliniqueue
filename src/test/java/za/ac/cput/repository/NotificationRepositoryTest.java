package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.factory.NotificationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NotificationRepositoryTest {

    private static INotificationRepository repository = NotificationRepository.getRepository();
    private static User sender = new User(1, "Annah Manda", "mandaanna@gmail.com");
    private static User recipient = new User(2, "Jane Smith", "masangaT@gmail.com");

    // Using NotificationFactory to create the notification
    private static Notification notification = NotificationFactory.createNotification(1, sender, recipient, "Your system will restart at midnight", "Pending");

    @Test
    void a_create() {
        Notification created = repository.create(notification);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Notification read = repository.read(String.valueOf(notification.getNotificationId())); // Ensure correct type
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Notification updatedNotification = new Notification.Builder()
                .copy(notification)
                .setMessage("Your system update is postponed to 2 AM")
                .build();
        Notification updated = repository.update(updatedNotification);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete(String.valueOf(notification.getNotificationId())));
        System.out.println("Success: Notification deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}
