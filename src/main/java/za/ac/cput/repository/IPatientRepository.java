package za.ac.cput.repository;

import za.ac.cput.domain.Patient;

import java.util.List;

public interface IPatientRepository extends IRepository <Patient, String>{

    List<Patient> getAll();
}
