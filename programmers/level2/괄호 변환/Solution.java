/* https://school.programmers.co.kr/learn/courses/30/lessons/60058
올바른 괄호 찾기 : 스택으로 찾기!
그냥 시키는 대로 구현하면 되는 문제..
*/

import java.util.*;

class Solution {
    // 괄호 나누기
    private String[] divide(String w){
        int right = 0;
        int left = 0;
        String[] divided = new String[2];

        int i=0;
        for (char c: w.toCharArray()){
            if (right == left && i !=0 ){
                break;
            }
            if (c == '('){
                left ++;
            }
            else right ++;
            i ++;
        }

        divided[0] = w.substring(0,i);
        divided[1] = w.substring(i);
        return divided;
    }

    // 올바른 괄호 찾기
    private Boolean isRight (String w){
        Stack<Character> stack = new Stack<>();

        for (char c: w.toCharArray()){
            if (c=='('){
                stack.push(c);
            }
            else{
                // 짝이 안맞는 경우
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째와 마지막 문자 제거
        for (int i = 1; i < u.length() - 1; i++) {
            // 나머지 문자열의 괄호 방향 뒤집기
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public String solution(String p) {
        String answer = "";

        if (p.isEmpty()) {
            return p;
        }

        String[] dividedP = this.divide(p);
        String u = dividedP[0];
        String v = dividedP[1];

        if (isRight(u)) {
            return u + solution(v);
        }

        return "(" + solution(v) + ")" + this.reverse(u);
    }
}