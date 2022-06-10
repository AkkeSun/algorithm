package com.example.algorithm.greedy;

/**
 * 각 자리가 숫자로 이루어진 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며
 * 숫자 사이에 'x' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성하세요
 * 단, +보다 x를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽부터 순서대로 진행된다
 */
public class GreedyExample3 {

    public static void main(String[] args) {
        logic("03426");
    }

    public static void logic (String s) {

        int sum = s.charAt(0) - '0';

        if(sum == 0 || sum == 1)
            sum += s.charAt(1) - '0';
        else
            sum *= s.charAt(1) - '0';

        for(int i=2; i<s.length(); i++) {

            if((s.charAt(i) - '0') <= 1) {
                sum += (s.charAt(i) - '0');
            } else {
                sum *= (s.charAt(i) - '0');
            }
        }

        System.out.println(sum);
    }
}
