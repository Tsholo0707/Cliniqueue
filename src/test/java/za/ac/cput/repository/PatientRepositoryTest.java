/*PatientRepositoryTest.java
Patient RepositoryTest class
Author: Tsholofelo Mabidikane (230018165)
Date: 27 March 2025
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Patient;
import za.ac.cput.factory.PatientFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class PatientRepositoryTest {
    private static IPatientRepository repository = PatientRepository.getRepository();
    private Patient patient = PatientFactory.createPatient("Minny", "Ferreria",
            "Female", "0648795763", LocalDate.of(2000, 2, 2),
            "20 Furry Street, ViewPoint", "B+", "0648972010");


    @Test
    void a_create() {
        Patient created = repository.create(patient);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Patient read = repository.read(patient.getPatientPhoneNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Patient updatedPatient = new Patient.Builder().copy(patient)
                .setPatientPhoneNumber("0796538674")
                .setPatientAddress("478 Elm Street, Johannesburg")
                .build();
        Patient updated = repository.update(updatedPatient);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete(patient.getPatientPhoneNumber()));
        System.out.println("Success: Patient Phone Number deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}