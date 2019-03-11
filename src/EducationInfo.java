public class EducationInfo {
    private double noHighSchool, onlyHighSchool, someCollege, bachelorsOrMore;

    public EducationInfo(double noHighSchool, double onlyHighSchool, double someCollege, double bachelorsOrMore) {
        this.noHighSchool = noHighSchool;
        this.onlyHighSchool = onlyHighSchool;
        this.someCollege = someCollege;
        this.bachelorsOrMore = bachelorsOrMore;
    }

    public double getNoHighSchool() {
        return noHighSchool;
    }

    public double getOnlyHighSchool() {
        return onlyHighSchool;
    }

    public double getSomeCollege() {
        return someCollege;
    }

    public double getBachelorsOrMore() {
        return bachelorsOrMore;
    }

   }

