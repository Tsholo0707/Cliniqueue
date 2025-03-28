/*ReportRepositoryTest.java
Report RepositoryTest class
Author: Tsholofelo Mabidikane (230018165)
Date: 27 March 2025
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Doctor;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.Report;
import za.ac.cput.factory.DoctorFactory;
import za.ac.cput.factory.ReportFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class ReportRepositoryTest {
    private static IReportRepository repository = ReportRepository.getRepository();
    private Report report = ReportFactory.createReport("Allergies", "RPT27648",
            "Allergy Test", "Allergy test results", "Medium",
            LocalDate.of(2025, 3, 1), DoctorFactory.createDoctor("Dr. Delport"),
            new Patient.Builder().setPatientFirstName("Zayn Zurich").build(), "Requires more allergy tests");

    @Test
    void a_create() {
        Report created = repository.create(report);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        Report read = repository.read(report.getReportId());
        assertNotNull(read);
        System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Report newReport = new Report.Builder().copy(report).setReportContent("Update allergy test results").build();
        Report updated = repository.update(newReport);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void d_delete() {
        assertTrue(repository.delete(report.getReportId()));
        System.out.println("Success: Report deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());
    }
}