package za.ac.cput.repository;

import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AvailabilityRepository implements IAvailabilityRepository {

    private static AvailabilityRepository repository = null;
    private Set<Availability> availabilitySet;

    private AvailabilityRepository() {
        availabilitySet = new HashSet<>();
    }

    public static AvailabilityRepository getRepository() {
        if (repository == null) {
            repository = new AvailabilityRepository();
        }
        return repository;
    }

    @Override
    public Availability create(Availability availability) {
        boolean success = availabilitySet.add(availability);
        return success ? availability : null;
    }

    @Override
    public Availability read(LocalDateTime dateTime) {
        for (Availability availability : availabilitySet) {
            if (availability.getDateTime().equals(dateTime))
                return availability;
        }
        return null;
    }

    @Override
    public Availability update(Availability availability) {
        Availability oldAvailability = read(availability.getDateTime());
        if (oldAvailability == null) return null;

        boolean success = delete(availability.getDateTime());
        if (success) {
            availabilitySet.add(availability);
            return availability;
        }
        return null;
    }

    @Override
    public boolean delete(LocalDateTime dateTime) {
        Availability availabilityToDelete = read(dateTime);
        if (availabilityToDelete == null) return false;
        return availabilitySet.remove(availabilityToDelete);
    }

    @Override
    public Set<Availability> getAll() {
        return availabilitySet;
    }
}

