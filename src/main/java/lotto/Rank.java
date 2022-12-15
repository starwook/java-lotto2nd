package lotto;

public enum Rank {
    FIRST(6,"2,000,000,000"),
    SECOND(5,"30,000,000"),
    THIRD(5,"1,500,000"),
    FOURTH(4,"50,000"),
    FIFTH(3,"5,000");


    private int countOfMatch;
    private String winningMoney;
    private Rank(int countOfMatch,String winningMoney){
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }
    public int getCountOfMatch(){
        return this.countOfMatch;
    }

    public String getWinningMoney(){
        return this.winningMoney;
    }
}
