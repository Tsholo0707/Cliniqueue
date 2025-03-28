package za.ac.cput.factory;

import za.ac.cput.domain.Notification;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;



public class NotificationFactory {
    public static Notification createNotification(int notificationId, User sender, User recipient, String message, String status) {
        if (notificationId <= 0) {
            return null;
        }
        if (sender == null || recipient == null) {
            return null;
        }
        if (!Helper.isValidMessage(message)) {
            return null;
        }
        if (!Helper.isValidStatus(status)) {
            return null;
        }

        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setSender(sender)
                .setRecipient(recipient)
                .setMessage(message)
                .setStatus(status)
                .build();
    }
}






