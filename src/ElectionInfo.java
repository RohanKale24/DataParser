public class ElectionInfo {
    private int demVotes,gopVotes,totalVotes,combinedFips;
    private String State, county;


    public ElectionInfo(int demVotes, int gopVotes, int totalVotes,String State, String county, int combinedFips){
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
        this.State = State;
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


    public void setDemVotes(int demVotes) {
        this.demVotes = demVotes;
    }

    public void setGopVotes(int gopVotes) {
        this.gopVotes = gopVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public String toString(){
        return demVotes + "," + gopVotes + "," + totalVotes;
    }

}
