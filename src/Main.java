import java.util.ArrayList;

/***
 * Main class for Data Parser
 */

public class Main {
    public static void main(String[] args) {
        Utils util = new Utils();
        ArrayList<ElectionResult> results = util.parseElectionResults();
    }

}
