import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public Utils() {

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
        for (int i = 8; i < employmentData.length; i++) {
            String vals = formatData(employmentData[i]);

            EducationInfo e = createEducationInfo(vals);

            totalEducationInfo.add(e);

        }
        return totalEducationInfo;
    }

    public ArrayList<EmploymentInfo> parseEmploymentInfo() {
        ArrayList<EmploymentInfo> totalEmploymentResults = new ArrayList<>();
        String[] employmentData = readFileAsString("data/Unemployment.csv").split("\n");
        for (int i = 8; i < employmentData.length; i++) {
            String vals = formatData(employmentData[i]);
            EmploymentInfo e = createEmploymentInfo(vals);
            totalEmploymentResults.add(e);
        }
        return totalEmploymentResults;
    }

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
        double votesPerDem = Double.parseDouble(vals[4]);
        double votesPerGop = Double.parseDouble(vals[5]);
        double diffBtwnDemAndGop = Double.parseDouble(vals[6]);
        double perPointDiff = Double.parseDouble(vals[7]);
        String state = vals[8];
        String county = vals[9];
        int combinedFips = (int) Double.parseDouble(vals[10]);
        ElectionInfo electionResult = new ElectionInfo(demVotes, gopVotes, totalVotes, votesPerDem, votesPerGop, diffBtwnDemAndGop, perPointDiff, state, county, combinedFips);
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

        int totalLaborForce = Integer.parseInt(vals[42].trim());
        int employedLaborForce = Integer.parseInt(vals[43].trim());
        int unemployedLaborForce = Integer.parseInt(vals[44].trim());
        double unemployedPercent = Double.parseDouble(vals[45].trim());
        return new EmploymentInfo(totalLaborForce, employedLaborForce, unemployedLaborForce, unemployedPercent);

    }

    private String removePercentage(String data) {

        String dataWithoutPercentage = data.substring(0, data.indexOf("%")) +
                data.substring(data.indexOf("%") + 1);
        return dataWithoutPercentage;
    }


}


