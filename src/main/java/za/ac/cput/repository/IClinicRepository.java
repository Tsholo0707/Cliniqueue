/*
 * IClinicRepository.java
 * Clinic Repository Interface
 * Author: Samkelisiwe Sithabile Khanyile(222843152)
 * Date: 27 March 2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Clinic;
import java.util.List;

public interface IClinicRepository extends IRepository<Clinic, String> {
    List<Clinic> getAll();
}
