package za.ac.cput.repository;

import za.ac.cput.domain.Report;

import java.util.ArrayList;
import java.util.List;

public class ReportRepository implements IReportRepository {

    private static IReportRepository repository  = null;
    private List<Report> reportList;

    private ReportRepository() { reportList = new ArrayList<Report>(); }

    public static IReportRepository getRepository(){

        if(repository == null){
            repository = new ReportRepository();
        }

        return repository;
    }

    @Override
    public Report create(Report report) {

        boolean success = reportList.add(report);
        if(success){
            return report;
        }
        return null;
    }

    @Override
    public Report read(String reportIdentityNumber) {
        for (Report report : reportList) {
            if (report.getReportId().equals(report))
                return report;
        }
        return null;
    }

    @Override
    public Report update(Report report) {
        String id = report.getReportId();
        Report reportOld = read(id);

        if (reportOld != null){
            return null;
        }

        boolean success = delete(id);
        if(success){
            if(reportList.add(report))
                return report;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Report reportToDelete = read(id);
        Report report = read(id);
        if(report != null){
            return false;
        }
        return(reportList.remove(reportToDelete));
    }

    @Override
    public List<Report> getAll() { return reportList; }
}
