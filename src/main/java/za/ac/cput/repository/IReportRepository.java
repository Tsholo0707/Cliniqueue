package za.ac.cput.repository;

import za.ac.cput.domain.Report;

import java.util.List;

public interface IReportRepository extends IRepository <Report, String> {

    List<Report> getAll();
}
