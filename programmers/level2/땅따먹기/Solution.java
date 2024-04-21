// https://school.programmers.co.kr/learn/courses/30/lessons/12913

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    int solution(int[][] land) {
        HashMap<Integer, List<Integer>> landSum = new HashMap<>();

        List<Integer> firstRow = new ArrayList<Integer>();
        for (int i=0 ; i<4; i++){
            firstRow.add(land[0][i]);
        }
        landSum.put(0, firstRow);

        for(int j=1; j< land.length; j++ ){
            List<Integer> beforeLandSum = landSum.get(j-1);
            List<Integer> thisRow = new ArrayList<Integer>();

            for (int k=0; k<4; k++){
                int maxVal = 0;
                for (int l=0; l<4; l++) {
                    if (k != l){
                        maxVal = Math.max(maxVal, beforeLandSum.get(l));}
                }
                thisRow.add(maxVal+land[j][k]);
            }
            landSum.put(j, thisRow);
        }
        List<Integer> totalLandSum = landSum.get(land.length-1);
        int answer = Collections.max(totalLandSum);

        return answer;
    }
}