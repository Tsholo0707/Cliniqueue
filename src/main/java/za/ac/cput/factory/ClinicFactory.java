package za.ac.cput.factory;

import za.ac.cput.domain.Clinic;
import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;

import java.util.List;

public class ClinicFactory {

    public static Clinic createClinic(String clinicId, String clinicName,
                                      String clinicAddress, String clinicPhoneNumber,
                                      List<Doctor> doctors) {

        if (Helper.isNullOrEmpty(clinicName) || Helper.isNullOrEmpty(clinicAddress))
            return null;

        if (!Helper.isValidPhoneNumber(clinicPhoneNumber))
            return null;

        return new Clinic.Builder()
                .setClinicId(clinicId)
                .setClinicName(clinicName)
                .setClinicAddress(clinicAddress)
                .setClinicPhoneNumber(clinicPhoneNumber)
                .setDoctors(doctors)
                .build();
    }
}
