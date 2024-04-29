// https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java

import java.util.*;

class Solution {
    private void search(int[][] computers, boolean[][] visited, Map<Integer, Boolean> visited_row, int row){
        visited_row.put(row, true);
        for (int i=0; i<computers.length; i++){
            if(computers[row][i] == 1 && !visited[row][i]){
                visited[row][i] = true;
                visited[i][row] = true;
                visited[i][i] = true;
                // 다음으로 연결된 row 탐색
                this.search(computers, visited, visited_row, i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        Map<Integer, Boolean> visited_row = new HashMap<>();
        boolean[][] visited = new boolean[computers.length][];

        for (int i=0; i< computers.length; i++){
            visited[i] = new boolean[computers[i].length];
            for (int j=0; j< computers.length; j++){
                visited[i][j] = false;
            }
        }

        for (int i=0; i< computers.length; i++){
            // row 연속으로 방문
            if (! visited_row.getOrDefault(i, false)){
                this.search(computers, visited, visited_row, i);
                answer ++ ;
            }
        }

        return answer;
    }
}