public class ElectionResult {
    int demVotes,gopVotes,totalVotes,combinedFips;
    double votesPerDem,votesPerGop,diffBtwnDemAndGop,perPointDiff;
    String state,county;

    public ElectionResult(int demVotes, int gopVotes, int totalVotes, double votesPerDem, double votesPerGop, double diffBtwnDemAndGop,double perPointDiff, String state, String county, int combinedFips){
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
        this.votesPerDem = votesPerDem;
        this.votesPerGop = votesPerGop;
        this.diffBtwnDemAndGop = diffBtwnDemAndGop;
        this.perPointDiff = perPointDiff;
        this.state = state;
        this.county = county;
        this.combinedFips = combinedFips;
    }


}
