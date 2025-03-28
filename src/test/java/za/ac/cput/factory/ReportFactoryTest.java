/*ReportFactoryTest.java
Report FactoryTest class
Author: Tsholofelo Mabidikane (230018165)
Date: 27 March 2025
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Doctor;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.Report;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ReportFactoryTest {

    private static  Report validReport = ReportFactory.createReport(
            "No prior conditions", "RPT263738", "Lab Test", "Blood test results",
            "High", LocalDate.of(2025, 3, 25), DoctorFactory.createDoctor("Dr. Smith"), new Patient.Builder().setPatientFirstName("John Vundla").build(), "No additional comments");

    private static Report reportWithInvalidId = ReportFactory.createReport(
            "Diabetes", "", "Blood Test","Glucose levels high",
            "High", LocalDate.of(2025,2,12), DoctorFactory.createDoctor("Dr. Williams"), new Patient.Builder().setPatientFirstName("Maria Lewis").build(), "Suggest lifestyle changes");

    private static Report reportWithNullDoctor = ReportFactory.createReport(
            "Allergy", "RPT475896", "MRI", "MRI scan results", "Low",
            LocalDate.of(2025, 1,30), DoctorFactory.createDoctor(""), new Patient.Builder().setPatientFirstName("Timothy Greens").build(), "No additional comments");

    private static Report reportWithInvalidPatient = ReportFactory.createReport(
            "Asthma", "RPT307020", "Chest X-Ray", "X-Ray results", "Medium",
            LocalDate.of(2024, 8, 15), DoctorFactory.createDoctor("Dr. Cassiro"), new Patient.Builder().setPatientFirstName("").build(), "Use inhalers and nebulizer every day");

    private static Report reportWithInvalidData = ReportFactory.createReport(
            "no prior conditions", "PRT115473", "General Checkup", "Routine Examination",
            "Medium", LocalDate.of(0, 0, 0), DoctorFactory.createDoctor("Dr. Vundla"), new Patient.Builder().setPatientFirstName("Bokamoso Kone").build(), "Patient is in good health");

    @Test
    @Order(1)
    public void testCreateValidReport() {
        assertNotNull(validReport, "Valid report should be created successfully");
        System.out.println("Created report: " + validReport);
    }

    @Test
    @Order(2)
    public void testCreateReportWithInvalidId() {
        assertNull(reportWithInvalidId, "Report with an invalid Id should not be created");
        System.out.println("Failed report creation with invalid Id: " + reportWithInvalidId);
    }

    @Test
    @Order(3)
    public void testCreateReportWithNullDoctor() {
        assertNull(reportWithNullDoctor, "Report with a null Doctor should not be created");
        System.out.println("Failed report creation with invalid Doctor: " + reportWithInvalidId);
    }

    @Test
    @Order(4)
    public void testCreateReportWithInvalidPatient() {
        assertNull(reportWithInvalidPatient, "Report with a null Patient should not be created");
        System.out.println("Failed report creation with invalid Patient: " + reportWithInvalidId);
    }

    @Test
    @Order(5)
    public void testCreateReportWithInvalidData() {
        assertNull(reportWithInvalidData, "Report with a null Data should not be created");
        System.out.println("Failed report creation with invalid Data: " + reportWithInvalidId);
    }
}
