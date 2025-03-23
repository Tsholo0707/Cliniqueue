/* Patient.java
Patient model class
Author: Tsholofelo Mabidikane(230018165)
Date 21 March 2025
*/
package za.ac.cput.domain;

import java.util.Date;

public class Patient {

    private String patientFirstName;
    private String patientLastName;
    private String patientGender;
    private String patientPhoneNumber;
    private Date patientDateOfBirth;
    private int patientId;
    private String patientAddress;
    private String patientBloodType;
    private String emergencyContact;

    private Patient() {
    }

    private Patient(Builder builder) {
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public Date getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public String getPatientBloodType() {
        return patientBloodType;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientGender='" + patientGender + '\'' +
                ", patientPhoneNumber='" + patientPhoneNumber + '\'' +
                ", patientDateOfBirth=" + patientDateOfBirth +
                ", patientId=" + patientId +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientBloodType='" + patientBloodType + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                '}';
    }

    public static class Builder {

        private String patientFirstName;
        private String patientLastName;
        private String patientGender;
        private String patientPhoneNumber;
        private Date patientDateOfBirth;
        private int patientId;
        private String patientAddress;
        private String patientBloodType;
        private String emergencyContact;

        public Builder setPatientFirstName(String patientFirstName) {
            this.patientFirstName = patientFirstName;
            return this;
        }

        public Builder setPatientLastName(String patientLastName) {
            this.patientLastName = patientLastName;
            return this;
        }

        public Builder setPatientGender(String patientGender) {
            this.patientGender = patientGender;
            return this;
        }

        public Builder setPatientPhoneNumber(String patientPhoneNumber) {
            this.patientPhoneNumber = patientPhoneNumber;
            return this;
        }

        public Builder setPatientDateOfBirth(Date patientDateOfBirth) {
            this.patientDateOfBirth = patientDateOfBirth;
            return this;
        }

        public Builder setPatientId(int patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder setPatientAddress(String patientAddress) {
            this.patientAddress = patientAddress;
            return this;
        }

        public Builder setPatientBloodType(String patientBloodType) {
            this.patientBloodType = patientBloodType;
            return this;
        }

        public Builder setEmergencyContact(String emergencyContact) {
            this.emergencyContact = emergencyContact;
            return this;
        }

        public Builder copy(Patient patient) {
            this.patientFirstName = patient.getPatientFirstName();
            this.patientLastName = patient.getPatientLastName();
            this.patientGender = patient.getPatientGender();
            this.patientPhoneNumber = patient.getPatientPhoneNumber();
            this.patientDateOfBirth = patient.getPatientDateOfBirth();
            this.patientId = patient.getPatientId();
            this.patientAddress = patient.getPatientAddress();
            this.patientBloodType = patient.getPatientBloodType();
            this.emergencyContact = patient.getEmergencyContact();
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }
}






