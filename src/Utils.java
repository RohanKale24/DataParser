import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public Utils() {

    }

    public ArrayList<EducationInfo> parseEducationInfo(){
        ArrayList<EducationInfo> totalEducationInfo = new ArrayList<>();
        String[] employmentData = readFileAsString("data/Unemployment.csv").split("\n");
        for (int i = 8; i < employmentData.length; i++) {
            String[] vals = formatData(employmentData[i]).split(",");

            double noHighSchool = Double.parseDouble(vals[43]);
            double onlyHighSchool = Double.parseDouble(vals[44]);
            double someCollege = Double.parseDouble(vals[45]);
            double bachelorsOrMore = Double.parseDouble(vals[46]);
            EducationInfo e = new EducationInfo(noHighSchool, onlyHighSchool, someCollege, bachelorsOrMore);
            totalEducationInfo.add(e);

        }
        return totalEducationInfo;
    }

    private String formatData(String data) {
        String normalizedString = "";
        char[] chars = data.toCharArray();
        boolean inQuotes = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"') {inQuotes = !inQuotes;}
            else if (!(inQuotes && chars[i] == ',')) {
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

    public ArrayList<ElectionResult> parseElectionResults() {
        String data = readFileAsString("data/2016_Presidential_Results.csv");

        ArrayList<ElectionResult> results = new ArrayList<>();

        String[] lines = data.split("\n");

        for (int i = 1; i < lines.length; i++) {

            String line = lines[i];

            if (line.contains("\"")) {

                String finalData = removeOddCharachters(line);

                ElectionResult electionResult = createElectionResult(finalData);

                results.add(electionResult);
            } else {

                String finalData = removePercentage(line);

                ElectionResult electionResult = createElectionResult(finalData);

                results.add(electionResult);
            }
        }
        return results;
    }

    private String removeOddCharachters(String line) {

        int indexOfApostrophe = line.indexOf("\"");

        int indexOfComma = line.indexOf(",", indexOfApostrophe);

        String dataWithoutPercentage = removePercentage(line);

        String dataWithoutExtraComma = removeComma(dataWithoutPercentage, indexOfComma, indexOfApostrophe);

        String dataWithoutApostrophe = removeApostrophe(dataWithoutExtraComma, indexOfApostrophe);

        return dataWithoutApostrophe;
    }

    private String removeComma(String dataWithoutPercentage, int indexOfComma, int indexOfApostrophe) {
        String dataWithoutExtraComma = dataWithoutPercentage.substring(0, indexOfComma) + dataWithoutPercentage.substring(indexOfComma + 1);

        if (dataWithoutExtraComma.indexOf(",", indexOfApostrophe) < dataWithoutExtraComma.indexOf("\"", indexOfApostrophe + 1) && dataWithoutExtraComma.indexOf(",", indexOfApostrophe) != -1) {


            int newIndexOfComma = dataWithoutExtraComma.indexOf(",", indexOfApostrophe);
            dataWithoutExtraComma = dataWithoutExtraComma.substring(0, newIndexOfComma) + dataWithoutExtraComma.substring(newIndexOfComma + 1);


        }
        return dataWithoutExtraComma;
    }

    private String removeApostrophe(String dataWithoutExtraComma, int indexOfApostrophe) {
        String dataWithoutFirstApostrophe = dataWithoutExtraComma.substring(0, indexOfApostrophe) +
                dataWithoutExtraComma.substring(indexOfApostrophe + 1);

        int indexOfSecondApostrophe = dataWithoutFirstApostrophe.indexOf("\"");

        String dataWithoutSecondApostrophe = dataWithoutFirstApostrophe.substring(0, indexOfSecondApostrophe)
                + dataWithoutFirstApostrophe.substring(indexOfSecondApostrophe + 1);

        return dataWithoutSecondApostrophe;
    }

    private ElectionResult createElectionResult(String data) {
        String[] categories = data.split(",");
        int demVotes = (int) Double.parseDouble(categories[1]);
        int gopVotes = (int) Double.parseDouble(categories[2]);
        int totalVotes = (int) Double.parseDouble(categories[3]);
        double votesPerDem = Double.parseDouble(categories[4]);
        double votesPerGop = Double.parseDouble(categories[5]);
        double diffBtwnDemAndGop = Double.parseDouble(categories[6]);
        double perPointDiff = Double.parseDouble(categories[7]);
        String state = categories[8];
        String county = categories[9];
        int combinedFips = (int) Double.parseDouble(categories[10]);
        ElectionResult electionResult = new ElectionResult(demVotes, gopVotes, totalVotes, votesPerDem, votesPerGop, diffBtwnDemAndGop, perPointDiff, state, county, combinedFips);
        return electionResult;
    }

    private String removePercentage(String data) {

        String dataWithoutPercentage = data.substring(0, data.indexOf("%")) +
                data.substring(data.indexOf("%") + 1);
        return dataWithoutPercentage;
    }


}


