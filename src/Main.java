import java.util.ArrayList;

/***
 * Main class for Data Parser
 */

public class Main {
    public static void main(String[] args) {
        Utils util = new Utils();
        String data = util.readFileAsString("C:\\Users\\gamem\\IdeaProjects\\DataParser\\data\\2016_Presidential_Results.csv");
        ArrayList<ElectionResult> results = util.parseElectionResults(data);
    }

}
