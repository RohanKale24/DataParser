import java.util.ArrayList;

public class State {
    private String name;
    private ArrayList<County> counties;

    public State(String name){
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
    public void setCountie(County newCounty){
        for(int i = 0; i < counties.size(); i++){
            County county = counties.get(i);
            if (county.getFips() == newCounty.getFips()) county = newCounty;
        }

    }


}
