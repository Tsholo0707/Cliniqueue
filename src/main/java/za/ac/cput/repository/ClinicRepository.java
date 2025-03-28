
/*
 * ClinicRepository.java
 * Clinic Repository Implementation
 * Author: Samkelisiwe Sithabile Khanyile(222843152)
 * Date: 27 March 2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Clinic;
import java.util.ArrayList;
import java.util.List;

public class ClinicRepository implements IClinicRepository {
    private static IClinicRepository repository = null;
    private List<Clinic> clinicList;

    private ClinicRepository() {
        clinicList = new ArrayList<>();
    }

    public static IClinicRepository getRepository() {
        if (repository == null) {
            repository = new ClinicRepository();
        }
        return repository;
    }

    @Override
    public Clinic create(Clinic clinic) {
        boolean success = clinicList.add(clinic);
        return success ? clinic : null;
    }

    @Override
    public Clinic read(String clinicId) {
        return clinicList.stream().filter(c -> c.getClinicId().equals(clinicId)).findFirst().orElse(null);
    }

    @Override
    public Clinic update(Clinic clinic) {
        Clinic oldClinic = read(clinic.getClinicId());
        if (oldClinic != null) {
            clinicList.remove(oldClinic);
            clinicList.add(clinic);
            return clinic;
        }
        return null;
    }

    @Override
    public boolean delete(String clinicId) {
        Clinic clinicToDelete = read(clinicId);
        return clinicToDelete != null && clinicList.remove(clinicToDelete);
    }

    @Override
    public List<Clinic> getAll() {
        return clinicList;
    }
}
