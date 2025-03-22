package za.ac.cput.domain;

import java.time.LocalDateTime;
import za.ac.cput.domain.Doctor;
import za.ac.cput.domain.Patient;
/**
 * Class: Appointment
 * Author: Sisanda Madikizela
 * Date: March 22, 2025,
 * Description: Manages patients bookings for appointment.
 */

public class Appointment {
    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private String status; // Scheduled, Completed, Cancelled

    private Appointment() {}

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.patient = builder.patient;
        this.doctor = builder.doctor;
        this.dateTime = builder.dateTime;
        this.status = builder.status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void reschedule(LocalDateTime newDateTime) {
        this.dateTime = newDateTime;
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public void complete() {
        this.status = "Completed";
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private int appointmentId;
        private Patient patient;
        private Doctor doctor;
        private LocalDateTime dateTime;
        private String status;

        public Builder setAppointmentId(int appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public Builder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Appointment appointment) {
            this.appointmentId = appointment.getAppointmentId();
            this.patient = appointment.getPatient();
            this.doctor = appointment.getDoctor();
            this.dateTime = appointment.getDateTime();
            this.status = appointment.getStatus();
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
