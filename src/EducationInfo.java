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

    public void setNoHighSchool(double noHighSchool) {
        this.noHighSchool = noHighSchool;
    }

    public void setOnlyHighSchool(double onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;
    }

    public void setBachelorsOrMore(double bachelorsOrMore) {
        this.bachelorsOrMore = bachelorsOrMore;
    }

    public void setSomeCollege(double someCollege) {
        this.someCollege = someCollege;
    }

    public String toString() {
        return noHighSchool + "," + onlyHighSchool + "," + someCollege + "," + bachelorsOrMore;
    }

}

