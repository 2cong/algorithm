// https://school.programmers.co.kr/learn/courses/30/lessons/250137

import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxT = attacks[attacks.length-1][0];

        int time = bandage[0];
        int recovery = bandage[1];
        int bonusRecovery = bandage[2];
        int maxHealth = health;

        Map<Integer, Integer> attack = new HashMap<>();
        for(int[] a: attacks){
            attack.put(a[0], a[1]);
        }

        int continuity = 0;
        for(int i=1; i<=maxT; i++){
            int a = attack.getOrDefault(i, 0);
            if (a != 0){
                continuity = 0;
                health = Math.max(0, health-a);
                if (health == 0){
                    health = -1;
                    break;
                }
            }
            else {
                continuity ++;
                health = Math.min(maxHealth, health+recovery);

                if (continuity == time){
                    continuity = 0;
                    health = Math.min(maxHealth, health+bonusRecovery);
                }
            }
        }

        return health;
    }
}