// https://school.programmers.co.kr/learn/courses/30/lessons/12923

import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int st = (int)begin;
        int ed = (int)end;
        int[] answer = new int[ed - st + 1];

        for (int i=ed; i>=st; i--){
            // 조건 만족하지 않는 곳에는 블럭 1
            answer[i-st] = 1;

            if (i == 1){
                answer[0] = 0;
            }

            else {
                // 2번째로 큰 약수를 구하면 됨!
                for (int j=2; j<= (int)Math.sqrt(i); j++){
                    if (i % j == 0){
                        // 제약 조건 : 그렙시는 길이가 1,000,000,000인 도로에 1부터 10,000,000까지의 숫자가 적힌 블록들을 이용해 위의 규칙대로 모두 설치
                        if (i / j <= 10000000){
                            answer[i-st] = i/j;
                            break;
                        }
                        else if (j <= 10000000){
                            answer[i-st] = j;
                        }
                    }
                }
            }
        }
        return answer;
    }
}