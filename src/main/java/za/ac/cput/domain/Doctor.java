/*
Doctor.java
Doctor model class
Author: Samkelisiwe Sithabile Khanyile
Date: 27 March 2025
*/

package za.ac.cput.domain;

public class Doctor {

    private final String doctorId;
    private final String firstName;
    private final String lastName;
    private final String specialization;
    private final String phoneNumber;
    private final String email;
    private final Clinic clinic; // Association with Clinic

    private Doctor(Builder builder) {
        this.doctorId = builder.doctorId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.specialization = builder.specialization;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.clinic = builder.clinic;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Clinic getClinic() {
        return clinic;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", clinic=" + (clinic != null ? clinic.getClinicName() : "None") +
                '}';
    }

    public static class Builder {
        private String doctorId;
        private String firstName;
        private String lastName;
        private String specialization;
        private String phoneNumber;
        private String email;
        private Clinic clinic;

        public Builder setDoctorId(String doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setClinic(Clinic clinic) {
            this.clinic = clinic;
            return this;
        }

        public Builder copy(Doctor doctor) {
            this.doctorId = doctor.doctorId;
            this.firstName = doctor.firstName;
            this.lastName = doctor.lastName;
            this.specialization = doctor.specialization;
            this.phoneNumber = doctor.phoneNumber;
            this.email = doctor.email;
            this.clinic = doctor.clinic;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }
}
