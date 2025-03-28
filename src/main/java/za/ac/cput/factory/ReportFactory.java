/*ReportFactory.java
Report model Factory class
Author: Tsholofelo Mabidikane (230018165)
Date: 23 March 2025
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Patient;
import za.ac.cput.domain.Report;
import za.ac.cput.domain.Doctor;
import za.ac.cput.util.Helper;
import java.time.LocalDate;


public class ReportFactory {

    public static Report createReport(String medicalHistory, String reportId, String reportType,
                                      String reportContent, String priorityLevel, LocalDate dateReportIssued,
                                       Doctor doctor, Patient patient, String comments) {

        if(Helper.isNullOrEmpty(medicalHistory) || Helper.isNullOrEmpty(reportId))
            return null;

        if(Helper.isNullOrEmpty(reportType) || Helper.isNullOrEmpty(reportContent))
            return null;

        if(Helper.isNullOrEmpty(priorityLevel) || Helper.isNullOrEmpty(comments))
            return null;

        if(dateReportIssued == null)
            return null;

        if(doctor == null || patient == null)
            return null;

        return new Report.Builder()
                .setMedicalHistory(medicalHistory)
                .setReportId(reportId)
                .setReportType(reportType)
                .setReportContent(reportContent)
                .setPriorityLevel(priorityLevel)
                .setDateReportIssued(dateReportIssued)
                .setDoctor(doctor)
                .setPatient(patient)
                .setComments(comments)
                .build();
    }
}
