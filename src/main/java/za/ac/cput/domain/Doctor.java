package za.ac.cput.domain;

/**
 * Doctor model class.
 * Author: Samkelisiwe Khanyile (222843152)
 * Date: 21/03/2025
 */
public class Doctor {
    private String doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phoneNumber;

    // Constructor, getters, and setters
    public Doctor(String doctorId, String firstName, String lastName, String specialization, String phoneNumber) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
