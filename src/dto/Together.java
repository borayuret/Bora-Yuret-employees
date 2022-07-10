package dto;

public class Together {
    private int emp1Id;
    private int emp2Id;
    private int projectId;
    private int days;

    public Together() {
    }

    public Together(int emp1Id, int emp2Id, int projectId, int days) {
        this.emp1Id = emp1Id;
        this.emp2Id = emp2Id;
        this.projectId = projectId;
        this.days = days;
    }

    public int getEmp1Id() {
        return emp1Id;
    }

    public void setEmp1Id(int emp1Id) {
        this.emp1Id = emp1Id;
    }

    public int getEmp2Id() {
        return emp2Id;
    }

    public void setEmp2Id(int emp2Id) {
        this.emp2Id = emp2Id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Together{" +
                "emp1Id=" + emp1Id +
                ", emp2Id=" + emp2Id +
                ", projectId=" + projectId +
                ", days=" + days +
                '}';
    }
}
