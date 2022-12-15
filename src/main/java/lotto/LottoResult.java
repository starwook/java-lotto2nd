package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static int START_COUNT =0;
    Map<Rank,Integer> rankCount = new LinkedHashMap<>();
    int totalReward;
    double sumRate;

    public LottoResult(){
        makeRankCount();
    }

    private void makeRankCount() {
        List<Rank> ranks = List.of(Rank.values());
        for(int i=0;i<ranks.size();i++){
            rankCount.put(ranks.get(i),START_COUNT);
        }
    }

}
