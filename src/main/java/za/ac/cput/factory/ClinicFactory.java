/*
ClinicFactory.java
Clinic model Factory class
Author: Samkelisiwe Sithabile Khanyile
Date: 27 March 2025
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Clinic;
import za.ac.cput.util.Helper;


public class ClinicFactory {

    public static Clinic createClinic(String clinicId, String clinicName, String clinicAddress, String clinicPhoneNumber) {
        if (Helper.isNullOrEmpty(clinicId) || Helper.isNullOrEmpty(clinicName) || Helper.isNullOrEmpty(clinicAddress))
            return null;

        if (!Helper.isValidPhoneNumber(clinicPhoneNumber))
            return null;

        return new Clinic.Builder()
                .setClinicId(clinicId)
                .setClinicName(clinicName)
                .setClinicAddress(clinicAddress)
                .setClinicPhoneNumber(clinicPhoneNumber)
                .build();
    }
}

