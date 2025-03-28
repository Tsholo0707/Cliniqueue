/*
Clinic.java
Clinic model class
Author: Samkelisiwe Sithabile Khanyile
Date: 27 March 2025
*/

package za.ac.cput.domain;

public class Clinic {

    private final String clinicId;
    private final String clinicName;
    private final String clinicAddress;
    private final String clinicPhoneNumber;
    private final String clinicEmail;
    private final String clinicType;

    private Clinic(Builder builder) {
        this.clinicId = builder.clinicId;
        this.clinicName = builder.clinicName;
        this.clinicAddress = builder.clinicAddress;
        this.clinicPhoneNumber = builder.clinicPhoneNumber;
        this.clinicEmail = builder.clinicEmail;
        this.clinicType = builder.clinicType;
    }

    public String getClinicId() {
        return clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public String getClinicPhoneNumber() {
        return clinicPhoneNumber;
    }

    public String getClinicEmail() {
        return clinicEmail;
    }

    public String getClinicType() {
        return clinicType;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinicId='" + clinicId + '\'' +
                ", clinicName='" + clinicName + '\'' +
                ", clinicAddress='" + clinicAddress + '\'' +
                ", clinicPhoneNumber='" + clinicPhoneNumber + '\'' +
                ", clinicEmail='" + clinicEmail + '\'' +
                ", clinicType='" + clinicType + '\'' +
                '}';
    }

    public static class Builder {
        private String clinicId;
        private String clinicName;
        private String clinicAddress;
        private String clinicPhoneNumber;
        private String clinicEmail;
        private String clinicType;

        public Builder setClinicId(String clinicId) {
            this.clinicId = clinicId;
            return this;
        }

        public Builder setClinicName(String clinicName) {
            this.clinicName = clinicName;
            return this;
        }

        public Builder setClinicAddress(String clinicAddress) {
            this.clinicAddress = clinicAddress;
            return this;
        }

        public Builder setClinicPhoneNumber(String clinicPhoneNumber) {
            this.clinicPhoneNumber = clinicPhoneNumber;
            return this;
        }

        public Builder setClinicEmail(String clinicEmail) {
            this.clinicEmail = clinicEmail;
            return this;
        }

        public Builder setClinicType(String clinicType) {
            this.clinicType = clinicType;
            return this;
        }

        public Builder copy(Clinic clinic) {
            this.clinicId = clinic.clinicId;
            this.clinicName = clinic.clinicName;
            this.clinicAddress = clinic.clinicAddress;
            this.clinicPhoneNumber = clinic.clinicPhoneNumber;
            this.clinicEmail = clinic.clinicEmail;
            this.clinicType = clinic.clinicType;
            return this;
        }

        public Clinic build() {
            return new Clinic(this);
        }
    }
}
