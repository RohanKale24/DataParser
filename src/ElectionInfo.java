public class ElectionInfo {
    private int demVotes,gopVotes,totalVotes;


    public ElectionInfo(int demVotes, int gopVotes, int totalVotes){
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;

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
