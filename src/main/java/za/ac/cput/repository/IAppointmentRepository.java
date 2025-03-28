package za.ac.cput.repository;

import za.ac.cput.domain.Appointment;
import java.util.Set;

public interface IAppointmentRepository extends IRepository<Appointment, String> {
    Set<Appointment> getAll();
}