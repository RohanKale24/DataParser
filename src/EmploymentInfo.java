public class EmploymentInfo {

    private int totalLaborForce,employedLaborForce,unemployedLaborForce;
    private double unemployedPercent;

    public EmploymentInfo(int totalLaborForce, int employedLaborForce, int unemployedLaborForce, double unemployedPercent){
        this.totalLaborForce = totalLaborForce;
        this.employedLaborForce = employedLaborForce;
        this.unemployedLaborForce = unemployedLaborForce;
        this.unemployedPercent = unemployedPercent;
    }
}
