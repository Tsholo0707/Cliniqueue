package za.ac.cput.repository;

import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepository implements IAppointmentRepository {
    private static AppointmentRepository repository = null;
    private Set<Appointment> appointmentSet;
    private AvailabilityRepository availabilityRepository;

    private AppointmentRepository() {
        appointmentSet = new HashSet<>();
        availabilityRepository = AvailabilityRepository.getRepository();
    }

    public static AppointmentRepository getRepository() {
        if (repository == null) {
            repository = new AppointmentRepository();
        }
        return repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        Availability availability = availabilityRepository.read(appointment.getDateTime());

        if (availability == null || !availability.isAvailable()) {
            System.out.println("Doctor is not available at this time. Appointment cannot be booked.");
            return null;
        }

        boolean success = appointmentSet.add(appointment);
        if (success) {
            availability.markUnavailable(); // Mark doctor as unavailable
            availabilityRepository.update(availability);
            return appointment;
        }
        return null;
    }

    @Override
    public Appointment read(String appointmentId) {
        for (Appointment appointment : appointmentSet) {
            if (appointment.getAppointmentId().equals(appointmentId))
                return appointment;
        }
        return null;
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment oldAppointment = read(appointment.getAppointmentId());
        if (oldAppointment == null) return null;

        boolean success = delete(oldAppointment.getAppointmentId());
        if (success) {
            appointmentSet.add(appointment);
            return appointment;
        }
        return null;
    }

    @Override
    public boolean delete(String appointmentId) {
        Appointment appointmentToDelete = read(appointmentId);
        if (appointmentToDelete == null) return false;

        boolean success = appointmentSet.remove(appointmentToDelete);
        if (success) {
            Availability availability = availabilityRepository.read(appointmentToDelete.getDateTime());
            if (availability != null) {
                availability.markAvailable(); // Mark doctor as available again
                availabilityRepository.update(availability);
            }
        }
        return success;
    }

    @Override
    public Set<Appointment> getAll() {
        return appointmentSet;
    }
}
