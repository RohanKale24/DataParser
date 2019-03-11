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

}
