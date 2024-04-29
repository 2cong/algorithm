// https://school.programmers.co.kr/learn/courses/30/lessons/12924#
// 투 포인터 방식 : 주어진 수 n 이 연속된 정수의 합으로 표현될 수 있는지 확인하는 데 사용
// 참고하면 좋은 블로그 : https://butter-shower.tistory.com/226


// 처음에 푼 방식 : 완전 탐색 ㅠ
//class Solution {
//    public int solution(int n) {
//        int answer = 1;
//        int middle = n/2;
//
//        if (n != 1 && middle + middle + 1 == n) {
//            answer+= 1;
//        }
//
//        for(int i=1; i < middle; i++){
//            int temp = i;
//            for(int j=i+1; j < middle; j++){
//                temp+=j;
//                System.out.println(temp);
//                if (temp >= n){
//                    break;
//                }
//            }
//            if(temp == n){
//                answer+=1;
//            }
//        }
//        return answer;
//    }
// }

class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1;
        int sum = 1;

        while (end <= n){
            if (sum < n){
                end += 1;
                sum += end;
            }
            else if (sum == n) {
                answer += 1;
                sum -= start;
                start += 1;
                end += 1;
                sum += end;
            }
            else {
                sum -= start;
                start += 1;
            }
        }

        return answer;
    }
}