import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Utils {

    private static final int MAX_FIPS_NUMBER = 72153;


    public Utils() {

    }

    public ArrayList<County> createCounties(){
        ArrayList<ElectionInfo> electionResults = parseElectionResults();
        ArrayList<EducationInfo> eduResults = parseEducationInfo();
        ArrayList<EmploymentInfo> employmentresults = parseEmploymentInfo();
        ArrayList<County> counties = new ArrayList<>();
        for (int i = 0; i < MAX_FIPS_NUMBER; i++) {
            County c = new County("add later",i);//finish this code block
             EducationInfo educationInfo = eduResults.get(i);
            EmploymentInfo employmentInfo = employmentresults.get(i);
            ElectionInfo electionInfo = electionResults.get(i);//I know it doesnt match up
            c.setEducationInfo(educationInfo);
            c.setElectionInfo(electionInfo);
            c.setEmploymentInfo(employmentInfo);
            counties.add(c);
        }
        return counties;
    }

    public ArrayList<State> createStates(){
        ArrayList<State> states =  new ArrayList<>();
        ArrayList<County> counties = createCounties();

        for (int i = 0; i < counties.size(); i++) {
            State state = new State("Name");//change
            state.add(counties.get(i));
        }
        return states;
    }

    public void assignStatesToDataManager(){
        DataManager d = new DataManager();
        ArrayList<State> states = createStates();
        for (int i = 0; i < states.size(); i++) {
             d.addState(states.get(i));

        }
    }

    public ArrayList<ElectionInfo> parseElectionResults() {
        String data = readFileAsString("data/2016_Presidential_Results.csv");

        ArrayList<ElectionInfo> results = new ArrayList<>();

        String[] electionData = data.split("\n");

        for (int i = 1; i < electionData.length; i++) {

            String vals = formatData(electionData[i]);

            vals = removePercentage(vals);

            ElectionInfo e = createElectionResult(vals);
            results.add(e);

        }
        return results;
    }

    public ArrayList<EducationInfo> parseEducationInfo() {
        ArrayList<EducationInfo> totalEducationInfo = new ArrayList<>();
        String[] employmentData = readFileAsString("data/Unemployment.csv").split("\n");
        for (int i = 7; i < employmentData.length; i++) {
            String vals = formatData(employmentData[i]);

            EducationInfo e = createEducationInfo(vals);

            totalEducationInfo.add(e);

        }
        return totalEducationInfo;
    }//debug

    public ArrayList<EmploymentInfo> parseEmploymentInfo() {
        ArrayList<EmploymentInfo> totalEmploymentResults = new ArrayList<>();
        String[] employmentData = readFileAsString("data/Unemployment.csv").split("\n");
        for (int i = 10; i < employmentData.length; i++) {
            String vals = formatData(employmentData[i]);
            EmploymentInfo e = createEmploymentInfo(vals);
            totalEmploymentResults.add(e);
        }
        return totalEmploymentResults;
    }//debug

    private String formatData(String data) {
        String normalizedString = "";
        char[] chars = data.toCharArray();
        boolean inQuotes = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"') {
                inQuotes = !inQuotes;
            } else if (!(inQuotes && chars[i] == ',')) {
                normalizedString += chars[i];
            }
        }
        return normalizedString;
    }

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    private ElectionInfo createElectionResult(String data) {
        String[] vals = data.split(",");
        int demVotes = (int) Double.parseDouble(vals[1]);
        int gopVotes = (int) Double.parseDouble(vals[2]);
        int totalVotes = (int) Double.parseDouble(vals[3]);
        ElectionInfo electionResult = new ElectionInfo(demVotes, gopVotes, totalVotes);
        return electionResult;
    }

    private EducationInfo createEducationInfo(String data) {
        String[] vals = data.split(",");

        double noHighSchool = Double.parseDouble(vals[43]);
        double onlyHighSchool = Double.parseDouble(vals[44]);
        double someCollege = Double.parseDouble(vals[45]);
        double bachelorsOrMore = Double.parseDouble(vals[46]);
        return new EducationInfo(noHighSchool, onlyHighSchool, someCollege, bachelorsOrMore);
    }

    private EmploymentInfo createEmploymentInfo(String data) {
        String[] vals = data.split(",");

        int totalLaborForce = Integer.parseInt(vals[42]);
        int employedLaborForce = Integer.parseInt(vals[43]);
        int unemployedLaborForce = Integer.parseInt(vals[44]);
        double unemployedPercent = Double.parseDouble(vals[45]);
        return new EmploymentInfo(totalLaborForce, employedLaborForce, unemployedLaborForce, unemployedPercent);

    }

    private String removePercentage(String data) {

        String dataWithoutPercentage = data.substring(0, data.indexOf("%")) +
                data.substring(data.indexOf("%") + 1);
        return dataWithoutPercentage;
    }


}


