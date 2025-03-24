package za.ac.cput.domain;

public class Doctor {
    private String doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorSpecialization;
    private String doctorPhoneNumber;
    private String doctorEmail;

    private Doctor(Builder builder) {
        this.doctorId = builder.doctorId;
        this.doctorFirstName = builder.doctorFirstName;
        this.doctorLastName = builder.doctorLastName;
        this.doctorSpecialization = builder.doctorSpecialization;
        this.doctorPhoneNumber = builder.doctorPhoneNumber;
        this.doctorEmail = builder.doctorEmail;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorFirstName='" + doctorFirstName + '\'' +
                ", doctorLastName='" + doctorLastName + '\'' +
                ", doctorSpecialization='" + doctorSpecialization + '\'' +
                ", doctorPhoneNumber='" + doctorPhoneNumber + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                '}';
    }

    public static class Builder {
        private String doctorId;
        private String doctorFirstName;
        private String doctorLastName;
        private String doctorSpecialization;
        private String doctorPhoneNumber;
        private String doctorEmail;

        public Builder setDoctorId(String doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder setDoctorFirstName(String doctorFirstName) {
            this.doctorFirstName = doctorFirstName;
            return this;
        }

        public Builder setDoctorLastName(String doctorLastName) {
            this.doctorLastName = doctorLastName;
            return this;
        }

        public Builder setDoctorSpecialization(String doctorSpecialization) {
            this.doctorSpecialization = doctorSpecialization;
            return this;
        }

        public Builder setDoctorPhoneNumber(String doctorPhoneNumber) {
            this.doctorPhoneNumber = doctorPhoneNumber;
            return this;
        }

        public Builder setDoctorEmail(String doctorEmail) {
            this.doctorEmail = doctorEmail;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }
}