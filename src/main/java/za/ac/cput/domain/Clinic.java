package za.ac.cput.domain;
/**
 * Clinic model class.
 * Author: Samkelisiwe Khanyile (222843152)
 * Date: 21/03/2025
 */
public class Clinic {

        private String clinicId;
        private String clinicName;
        private String clinicAddress;
        private String phoneNumber;

        // Constructor, getters, and setters
        public Clinic(String clinicId, String clinicName, String clinicAddress, String phoneNumber) {
            this.clinicId = clinicId;
            this.clinicName = clinicName;
            this.clinicAddress = clinicAddress;
            this.phoneNumber = phoneNumber;
        }

        // Getters and setters
        public String getClinicId() {
            return clinicId;
        }

        public void setClinicId(String clinicId) {
            this.clinicId = clinicId;
        }

        public String getClinicName() {
            return clinicName;
        }

        public void setClinicName(String clinicName) {
            this.clinicName = clinicName;
        }

        public String getClinicAddress() {
            return clinicAddress;
        }

        public void setClinicAddress(String clinicAddress) {
            this.clinicAddress = clinicAddress;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

