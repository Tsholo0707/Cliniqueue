/*
 * IDoctorRepository.java
 * Doctor Repository Interface
 * Author: Samkelisiwe Sithabile Khanyile(222843152)
 * Date: 27 March 2025
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Doctor;
import java.util.List;

public interface IDoctorRepository extends IRepository<Doctor, String> {
    List<Doctor> getAll();
}
