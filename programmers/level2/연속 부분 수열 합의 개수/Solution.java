//https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.* ;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        int n = elements.length;
        int[] currentSums = Arrays.copyOf(elements, n);

        Queue<Integer> eles = new LinkedList<>();

        for (int ele: elements){
            answer.add(ele);
            eles.add(ele);
        }

        int startN = eles.poll();
        eles.add(startN);

        for (int i=2; i<=elements.length; i++){
            int[] now = new int[n];
            int j = 0;
            for (int k : eles){
                int addN = currentSums[j] + k;
                answer.add(addN);
                now[j] = addN;
                j++;
            }
            currentSums = now;
            startN = eles.poll();
            eles.add(startN);
        }

        return answer.size();
    }
}