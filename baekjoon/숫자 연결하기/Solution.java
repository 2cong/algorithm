//https://www.acmicpc.net/problem/1323
//문제는 위 문제인데 푼 건 코딩 테스트에서 풀었음
//
//내가 처음 푼 방식
//Runtime Error
//import java.util.Set;
//import java.util.HashSet;
//
//class Solution {
//    public int solution(int n, int k) {
//        String numStr = Integer.toString(n);
//        String current = numStr;
//        int i = 1;
//        Set<Long> remainGroup = new HashSet<>();
//
//        while (true){
//            long number = Long.parseLong(current);
//            long remain = number % k;
//            if (remain == 0) {
//                return i;
//            }
//            if (!remainGroup.add(remain)) {
//                return -1;
//            }
//            current += numStr;
//            i++;
//        }
//    }
//}


// 모듈러 연산(a를 b로 나눈 나머지를 구하는 연산) 이용
// 참고 1) https://velog.io/@letgodchan0/%EB%B0%B1%EC%A4%80-1323%EB%B2%88-%EC%88%AB%EC%9E%90-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0
// 참고 2) https://dalseoin.tistory.com/entry/%EB%B0%B1%EC%A4%80-1323-%EC%88%AB%EC%9E%90-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0

// 모듈러 연산을 사용하여 문제 푸는 방식
//
//n을 k로 나눈 나머지를 구하기 나머지를 r이라고 함
//r에 n을 이어붙이기 예를 들어 r=3, n=5라면 r=35
//r을 k로 나눈 새로운 나머지를 구함
//새로운 나머지가 0이면 종료

class Solution {
    public int solution(int n, int k) {
        if (n % k == 0) return 0; // 이미 나누어떨어지는 경우

        Set<Integer> remainSet = new HashSet<>();
        int remainder = n % k;
        int count = 1;
        while (!remainSet.contains(remainder)) {
            remainSet.add(remainder);
            remainder = (remainder * 10 + n) % k;
            count++;
            if (remainder == 0) return count; // 나누어떨어지면 현재까지의 횟수 반환
        }
        return -1; // 반복되는 나머지가 발생하여 나누어떨어지지 않는 경우
    }
}





