// https://school.programmers.co.kr/learn/courses/30/lessons/258712

import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> giftLevels = new HashMap<>();
        Map<String, Map<String, Integer>> giveGifts = new HashMap<>();

        for (String gift : gifts){
            String giver = gift.split(" ")[0];
            String taker = gift.split(" ")[1];
            giftLevels.put(giver, giftLevels.getOrDefault(giver, 0)+1);
            giftLevels.put(taker, giftLevels.getOrDefault(taker, 0)-1);

            Map<String, Integer> giveGift = giveGifts.getOrDefault(giver, new HashMap<>());
            giveGift.put(taker, giveGift.getOrDefault(taker, 0) + 1);
            giveGifts.put(giver, giveGift);
        }

        for (String i : friends){
            int myGift = 0;
            for (String j : friends){
                if (i != j){
                    Map<String, Integer> myGifts = giveGifts.getOrDefault(i, new HashMap<>());
                    Map<String, Integer> theirGifts = giveGifts.getOrDefault(j, new HashMap<>());

                    int given = myGifts.getOrDefault(j, 0);
                    int taken = theirGifts.getOrDefault(i, 0);

                    if (given > taken || (given == taken && giftLevels.getOrDefault(i, 0) > giftLevels.getOrDefault(j, 0))) {
                        myGift++;
                    }
                }
            }
            if (myGift > answer){
                answer = myGift;
            }
        }
        return answer;
    }
}