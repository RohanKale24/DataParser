public class EmploymentInfo {

    private int totalLaborForce,employedLaborForce,unemployedLaborForce;
    private double unemployedPercent;

    public EmploymentInfo(int totalLaborForce, int employedLaborForce, int unemployedLaborForce, double unemployedPercent){
        this.totalLaborForce = totalLaborForce;
        this.employedLaborForce = employedLaborForce;
        this.unemployedLaborForce = unemployedLaborForce;
        this.unemployedPercent = unemployedPercent;
    }
    public int getTotalLaborForce() {
        return totalLaborForce;
    }
    public int getEmployedLaborForce() {
        return employedLaborForce;
    }
    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }
    public double getUnemployedPercent() {
        return unemployedPercent;
    }

}
