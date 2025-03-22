package za.ac.cput.domain;

import java.time.LocalDateTime;
/**
 * Class: Availability
 * Author: Sisanda Madikizela
 * Date: March 22, 2025,
 * Description: Manages Availability of Doctors for appointment.
 */

public class Availability {
    private Doctor doctor;
    private LocalDateTime dateTime;
    private boolean isAvailable;

    private Availability() {}

    private Availability(Builder builder) {
        this.doctor = builder.doctor;
        this.dateTime = builder.dateTime;
        this.isAvailable = builder.isAvailable;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markUnavailable() {
        this.isAvailable = false;
    }

    public void markAvailable() {
        this.isAvailable = true;
    }

    public boolean checkAvailability(LocalDateTime dateTime) {
        return this.isAvailable && this.dateTime.equals(dateTime);
    }

    @Override
    public String toString() {
        return "Availability{" +
                "doctor=" + doctor +
                ", dateTime=" + dateTime +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public static class Builder {
        private Doctor doctor;
        private LocalDateTime dateTime;
        private boolean isAvailable;

        public Builder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setIsAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public Builder copy(Availability availability) {
            this.doctor = availability.getDoctor();
            this.dateTime = availability.getDateTime();
            this.isAvailable = availability.isAvailable();
            return this;
        }

        public Availability build() {
            return new Availability(this);
        }
    }
}
