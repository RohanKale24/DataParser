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

    public int getDemVotes() {
        return demVotes;
    }

    public int getGopVotes() {
        return gopVotes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public double getVotesPerDem() {
        return votesPerDem;
    }

    public double getVotesPerGop() {
        return votesPerGop;
    }

    public double getDiffBtwnDemAndGop() {
        return diffBtwnDemAndGop;
    }

    public double getPerPointDiff() {
        return perPointDiff;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public int getCombinedFips() {
        return combinedFips;
    }

    public void setDemVotes(int demVotes) {
        this.demVotes = demVotes;
    }

    public void setGopVotes(int gopVotes) {
        this.gopVotes = gopVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public void setVotesPerDem(double votesPerDem) {
        this.votesPerDem = votesPerDem;
    }

    public void setVotesPerGop(double votesPerGop) {
        this.votesPerGop = votesPerGop;
    }

    public void setDiffBtwnDemAndGop(double diffBtwnDemAndGop) {
        this.diffBtwnDemAndGop = diffBtwnDemAndGop;
    }

    public void setPerPointDiff(double perPointDiff) {
        this.perPointDiff = perPointDiff;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setCombinedFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }
}
