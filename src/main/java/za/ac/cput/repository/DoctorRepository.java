/*
 * DoctorRepository.java
 * Doctor Repository Implementation
 * Author: Samkelisiwe Sithabile Khanyile
 * Date: 27 March 2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository implements IDoctorRepository {
    private static IDoctorRepository repository = null;
    private List<Doctor> doctorList;

    private DoctorRepository() {
        doctorList = new ArrayList<>();
    }

    public static IDoctorRepository getRepository() {
        if (repository == null) {
            repository = new DoctorRepository();
        }
        return repository;
    }

    @Override
    public Doctor create(Doctor doctor) {
        boolean success = doctorList.add(doctor);
        return success ? doctor : null;
    }

    @Override
    public Doctor read(String doctorId) {
        return doctorList.stream().filter(d -> d.getDoctorId().equals(doctorId)).findFirst().orElse(null);
    }

    @Override
    public Doctor update(Doctor doctor) {
        Doctor oldDoctor = read(doctor.getDoctorId());
        if (oldDoctor != null) {
            doctorList.remove(oldDoctor);
            doctorList.add(doctor);
            return doctor;
        }
        return null;
    }

    @Override
    public boolean delete(String doctorId) {
        Doctor doctorToDelete = read(doctorId);
        return doctorToDelete != null && doctorList.remove(doctorToDelete);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorList;
    }
}
