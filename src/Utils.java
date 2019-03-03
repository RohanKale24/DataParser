import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public Utils(){

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

    public ArrayList<ElectionResult> parseElectionResults(String data){
        ArrayList<ElectionResult> results = new ArrayList<>();
        String[] lines = data.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            int indexOfApostrophe = line.indexOf("\"");
            int indexOfSecondApostrophe = line.indexOf("\"",indexOfApostrophe+1);

            int indexOfComma = line.indexOf(",",indexOfApostrophe);

            String dataWithoutExtraComma = line.substring(0,indexOfComma) + line.substring(indexOfComma+1);
            String dataWithoutPercentage = line.substring(0,line.indexOf("%"))+line.substring(line.indexOf("%")+1);

            String finalData = line.substring(0,indexOfApostrophe)+
                    line.substring(indexOfApostrophe+1,indexOfSecondApostrophe)+
                    line.substring(indexOfApostrophe+1);




            String[] categories = finalData.split(",");
            int demVotes = Integer.parseInt(categories[1]);
            int gopVotes = Integer.parseInt(categories[2]);
            int totalVotes = Integer.parseInt(categories[3]);
            double votesPerDem = Double.parseDouble(categories[4]);
            double votesPerGop = Double.parseDouble(categories[5]);
            double diffBtwnDemAndGop = Double.parseDouble(categories[6]);
            double perPointDiff = Double.parseDouble(categories[7]);
            String state = categories[8];
            String county = categories[9];
            int combinedFips = Integer.parseInt(categories[10]);
            ElectionResult electionResult = new ElectionResult(demVotes, gopVotes, totalVotes, votesPerDem, votesPerGop, diffBtwnDemAndGop,perPointDiff, state, county, combinedFips);
            results.add(electionResult);
        }
        return results;
    }



}


