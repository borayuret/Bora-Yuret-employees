package dto;

import java.util.Date;

public class Input {
    private int empId;
    private int projectId;
    private Date dateFrom;
    private Date dateTo;

    public Input() {
    }

    public Input(int empId, int projectId, Date dateFrom, Date dateTo) {
        this.empId = empId;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "Input{" +
                "empId=" + empId +
                ", projectId=" + projectId +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }


}
