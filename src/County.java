public class County {

    private String name;
    private int fips;
    private ElectionInfo electionInfo;
    private EducationInfo educationInfo;
    private EmploymentInfo employmentInfo;

    public County(String name, int fips) {
        this.name = name;
        this.fips = fips;
        electionInfo = new ElectionInfo(-1, -1, -1);
        educationInfo = new EducationInfo(-1, -1, -1, -1);
        employmentInfo = new EmploymentInfo(-1, -1, -1, -1);
    }

    public String getName() {
        return name;
    }

    public int getFips() {
        return fips;
    }

    public ElectionInfo getElectionInfo() {
        return electionInfo;
    }

    public EducationInfo getEducationInfo() {
        return educationInfo;
    }

    public EmploymentInfo getEmploymentInfo() {
        return employmentInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public void setElectionInfo(ElectionInfo electionInfo) {
        this.electionInfo = electionInfo;
    }

    public void setEducationInfo(EducationInfo educationInfo) {
        this.educationInfo = educationInfo;
    }

    public void setEmploymentInfo(EmploymentInfo employmentInfo) {
        this.employmentInfo = employmentInfo;
    }
    public String toString(){
        return fips + "," + name + "," + electionInfo.toString() + "," + educationInfo.toString() + "," + employmentInfo.toString();
    }
}
