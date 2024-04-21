// https://school.programmers.co.kr/learn/courses/30/lessons/12914

import java.util.HashMap;

class Solution {
    public long solution(int n) {
        long[] possibleN = new long[n+1];

        if (n==1){
            return 1%1234567;
        }

        possibleN[1] = 1;
        possibleN[2] = 2;

        for (int i=3; i<=n; i++){
            possibleN[i] = (possibleN[i-1]+possibleN[i-2]) % 1234567;
        }

        return possibleN[n];
    }
}