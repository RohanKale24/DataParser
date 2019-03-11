import java.util.ArrayList;

public class State {
    private String name;
    private ArrayList<County> counties;

    public State(String name) {
        this.name = name;
        counties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<County> getCounties() {
        return counties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounties(ArrayList<County> counties) {
        this.counties = counties;
    }

    public void setCountie(County newCounty) {
        for (int i = 0; i < counties.size(); i++) {
            County county = counties.get(i);
            if (county.getFips() == newCounty.getFips()) county = newCounty;
        }

    }

    public int countyIndex(String name) {
        for (int i = 0; i < counties.size(); i++) {
            County county = counties.get(i);
            if (county.getName().equals(name)) return i;
        }
        return -1;
    }

    public int countyIndex(int fips) {
        for (int i = 0; i < counties.size(); i++) {
            County county = counties.get(i);
            if (county.getFips() == fips) return i;
        }
        return -1;
    }

    public void add(County county) {
        counties.add(county);
    }

    public void removeCounty(County county) {
        counties.remove(county);
    }

    public County removeCounty(int index) {
        return counties.remove(index);
    }


}
