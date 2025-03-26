package za.ac.cput.domain;

import java.util.List;

public class Clinic {
    private String clinicId;
    private String clinicName;
    private String clinicAddress;
    private String clinicPhoneNumber;
    private List<Doctor> doctors;

    private Clinic(Builder builder) {
        this.clinicId = builder.clinicId;
        this.clinicName = builder.clinicName;
        this.clinicAddress = builder.clinicAddress;
        this.clinicPhoneNumber = builder.clinicPhoneNumber;
        this.doctors = builder.doctors;
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinicId='" + clinicId + '\'' +
                ", clinicName='" + clinicName + '\'' +
                ", clinicAddress='" + clinicAddress + '\'' +
                ", clinicPhoneNumber='" + clinicPhoneNumber + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    public static class Builder {
        private String clinicId;
        private String clinicName;
        private String clinicAddress;
        private String clinicPhoneNumber;
        private List<Doctor> doctors;

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

        public Builder setDoctors(List<Doctor> doctors) {
            this.doctors = doctors;
            return this;
        }

        public Clinic build() {
            return new Clinic(this);
        }
    }
}
