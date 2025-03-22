package za.ac.cput.domain;

import java.util.Date;

public class Report {

    //private ArrayList<Appointment> appointmentList;
    private String medicalHistory;
    private int reportId;
    private String reportType;
    private String reportContent;
    private String priorityLevel;
    private Date dateReportIssued;
    //private Doctor doctor;
    //private Patient patient;
    private String comments;

    private Report(){
    }

    private Report(Builder builder){

        //this.appointmentList = builder.appointmentList;
        this.medicalHistory = builder.medicalHistory;
        this.reportId = builder.reportId;
        this.reportType = builder.reportType;
        this.reportContent = builder.reportContent;
        this.priorityLevel = builder.priorityLevel;
        this.dateReportIssued = builder.dateReportIssued;
        //this.doctor = builder.doctor;
        //this.patient = builder.patient;
        this.comments = builder.comments;
    }

//    public String getAppointmentList() {
//        return appointmentList;
//    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public int getReportId() {
        return reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public String getContent() {
        return reportContent;
    }
    public String getPriorityLevel() {
        return priorityLevel;
    }
    public Date getDateReportIssued() {
        return dateReportIssued;
    }
    //    public Doctor getDoctor() {
//        return doctor;
//    }
//    public Patient getPatient() {
//        return patient;
//    }
    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Report{" +
                //", appointmentList=' " + appointmentList + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", reportId=" + reportId +
                ", reportType='" + reportType + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", priorityLevel='" + priorityLevel + '\'' +
                ", dateReportIssued=" + dateReportIssued +
                //", doctor=" + doctor + '\'' +
                //", patient=" + patient + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public static class Builder {

        //private String appointmentList;
        private String medicalHistory;
        private int reportId;
        private String reportType;
        private String reportContent;
        private String priorityLevel;
        private Date dateReportIssued;
        //private Doctor doctor;
        //private Patient patient;
        private String comments;


        //        public Builder setAppointmentList(String appointmentList) {
//            this.appointmentList = appointmentList;
//            return this;
//        }
        public Builder setMedicalHistory(String medicalHistory) {
            this.medicalHistory = medicalHistory;
            return this;
        }
        public Builder setReportId(int reportId) {
            this.reportId = reportId;
            return this;
        }
        public Builder setReportType(String reportType) {
            this.reportType = reportType;
            return this;
        }
        public Builder setContent(String reportContent) {
            this.reportContent = reportContent;
            return this;
        }
        public Builder setPriorityLevel(String priorityLevel) {
            this.priorityLevel = priorityLevel;
            return this;
        }
        public Builder setDateReportIssued(Date dateReportIssued) {
            this.dateReportIssued = dateReportIssued;
            return this;
        }

//        public Builder setDoctor(Doctor) {
//            this.doctor = doctor;
//            return this;
//        }

//        public Builder setPatient(Patient) {
//            this.patient = patient;
//            return this
//        }

        public Builder setComments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder copy(Report report){
            //this.appointmentList = report.appointmentList;
            this.medicalHistory = report.medicalHistory;
            this.reportId = report.reportId;
            this.reportType = report.reportType;
            this.reportContent = report.reportContent;
            this.priorityLevel = report.priorityLevel;
            this.dateReportIssued = report.dateReportIssued;
            //this.doctor = report.doctor;
            //this.patient = report.patient;
            this.comments = report.comments;
            return this;
        }

        public Report build(){
            return new Report(this);
        }
    }
}

