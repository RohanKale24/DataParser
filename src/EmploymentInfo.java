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
    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }
    public void setEmployedLaborForce(int employedLaborForce) {
        this.employedLaborForce = employedLaborForce;
    }
    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }
    public void setUnemployedPercent(double unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
    }
    public String toString(){
        return totalLaborForce + "," + employedLaborForce + "," + unemployedLaborForce + "," + unemployedPercent;
    }

}
