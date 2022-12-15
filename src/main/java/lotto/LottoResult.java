package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static int START_COUNT =0;
    private Map<Rank,Integer> rankCount = new LinkedHashMap<>();
    private int totalPrice =0;
    private int purchase;
    private double sumRate;

    public LottoResult(int purchase){
        this.purchase = purchase;
        makeRankCount();
    }

    private void makeRankCount() {
        List<Rank> ranks = List.of(Rank.values());
        for(int i=0;i<ranks.size();i++){
            rankCount.put(ranks.get(i),START_COUNT);
        }
    }
    public void changeRankCount(Rank rank){
        rankCount.put(rank,rankCount.get(rank)+1);
        int price = Integer.parseInt(rank.getWinningMoney().replaceAll(",",""));
        totalPrice+=price;
    }

    public void calculateSumRate(){
        sumRate = Math.round(totalPrice/(double)purchase*10000)/100.0;
    }

    public double getSumRate(){
        return sumRate;
    }

    public Map<Rank,Integer> getRankCount(){
        return rankCount;
    }

    public int getTotalPrice(){
        return totalPrice;
    }

}
