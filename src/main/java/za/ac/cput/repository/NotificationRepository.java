package za.ac.cput.repository;

import za.ac.cput.domain.Notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationRepository implements INotificationRepository {

    private static NotificationRepository repository = null;
    private List<Notification> notificationList;

    private NotificationRepository() {
        this.notificationList = new ArrayList<>();
    }

    public static NotificationRepository getRepository() {
        if (repository == null) {
            repository = new NotificationRepository();
        }
        return repository;
    }

    @Override
    public Notification create(Notification notification) {
        return notificationList.add(notification) ? notification : null;
    }

    @Override
    public Notification read(String notificationId) {
        try {
            int id = Integer.parseInt(notificationId); // Convert String to int
            for (Notification notification : notificationList) {
                if (notification.getNotificationId() == id) { // Compare IDs correctly
                    return notification;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid notification ID format: " + notificationId);
        }
        return null;
    }

    @Override
    public Notification update(Notification notification) {
        Notification oldNotification = read(String.valueOf(notification.getNotificationId()));
        if (oldNotification != null && delete(String.valueOf(notification.getNotificationId()))) {
            notificationList.add(notification);
            return notification;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Notification notificationToDelete = read(id);
        return notificationToDelete != null && notificationList.remove(notificationToDelete);
    }

    @Override
    public List<Notification> getAll() {
        return new ArrayList<>(notificationList); // Return a copy to prevent modification
    }
}
