import java.util.ArrayList;

public class DataManager {
    private ArrayList<State> states;

    public DataManager(){
        states = new ArrayList<>();
    }
    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }
    public int stateIndex(String name){
        for (int i = 0; i < states.size(); i++){
            State state = states.get(i);
            if (state.getName().equals(name)) return i;
        }
        return -1;
    }

    public void addState(State state){
        states.add(state);
    }
    public void removeState(int index){
        states.remove(index);
    }


}
