import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public Utils() {

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

    public ArrayList<ElectionResult> parseElectionResults(String data) {
        ArrayList<ElectionResult> results = new ArrayList<>();
        String[] lines = data.split("\n");

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];


            if (line.contains("\"")) {
                int indexOfApostrophe = line.indexOf("\"");
                int indexOfComma = line.indexOf(",", indexOfApostrophe);


                String dataWithoutPercentage = line.substring(0, line.indexOf("%")) +
                        line.substring(line.indexOf("%") + 1);

                String dataWithoutExtraComma = dataWithoutPercentage.substring(0, indexOfComma) + dataWithoutPercentage.substring(indexOfComma + 1);

                if (dataWithoutExtraComma.indexOf(",", indexOfApostrophe) < dataWithoutExtraComma.indexOf("\"", indexOfApostrophe + 1) && dataWithoutExtraComma.indexOf(",", indexOfApostrophe) != -1) {


                    int newIndexOfComma = dataWithoutExtraComma.indexOf(",", indexOfApostrophe);
                    dataWithoutExtraComma = dataWithoutExtraComma.substring(0, newIndexOfComma) + dataWithoutExtraComma.substring(newIndexOfComma + 1);


                }


                String dataWithoutFirstApostrophe = dataWithoutExtraComma.substring(0, indexOfApostrophe) +
                        dataWithoutExtraComma.substring(indexOfApostrophe + 1);
                int indexOfSecondApostrophe = dataWithoutFirstApostrophe.indexOf("\"");
                String dataWithoutSecondApostrophe = dataWithoutFirstApostrophe.substring(0, indexOfSecondApostrophe)
                        + dataWithoutFirstApostrophe.substring(indexOfSecondApostrophe + 1);


                String[] categories = dataWithoutSecondApostrophe.split(",");
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
                electionResult.toString();
                results.add(electionResult);
            } else {

                String dataWithoutPercentage = line.substring(0, line.indexOf("%")) +
                        line.substring(line.indexOf("%") + 1);
                String[] categories = dataWithoutPercentage.split(",");
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
                electionResult.toString();
                results.add(electionResult);
            }
        }
        return results;
    }


}


