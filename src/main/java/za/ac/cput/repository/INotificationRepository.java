

package za.ac.cput.repository;

import za.ac.cput.domain.Notification;
import java.util.List;

public interface INotificationRepository extends IRepository<Notification, String> {
    List<Notification> getAll();
}
