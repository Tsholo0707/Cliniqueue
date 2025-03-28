package za.ac.cput.repository;

import za.ac.cput.domain.Availability;
import java.time.LocalDateTime;
import java.util.Set;

public interface IAvailabilityRepository extends IRepository<Availability, LocalDateTime> {
    Set<Availability> getAll();
}
