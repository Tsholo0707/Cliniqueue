package za.ac.cput.repository;

import za.ac.cput.domain.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements IPatientRepository {

    private static IPatientRepository repository = null;
    private List<Patient> patientList;

    private PatientRepository() {
        patientList = new ArrayList<Patient>();
    }
    public static IPatientRepository getRepository() {
        if (repository == null) {
            repository = new PatientRepository();
        }
        return repository;
    }

    @Override
    public Patient create(Patient patient) {
        boolean success = patientList.add(patient);
        if(success) {
            return patient;
        }
        return null;
    }

    @Override
    public Patient read(String userId) {
        for (Patient patient : patientList) {
            if (patient.getUserIdentityNumber().equals(patient)) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public Patient update(Patient patient) {
        String id = patient.getUserIdentityNumber();
        Patient patientOld = read(id);

        if(patientOld != null) {
            return null;
        }

        boolean success = delete(id);
        if (success) {
            if (patientList.add(patient)) {
                return patient;
            }
        }
        return null;
}

    @Override
    public boolean delete(String userId) {
        Patient patientToDelete = read(userId);
        if(patientToDelete != null) {
            return patientList.remove(patientToDelete);
        }
        return false;
    }

    @Override
    public List<Patient> getAll() {
        return patientList;
    }
}
