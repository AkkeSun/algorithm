package com.example.algorithm.greedy;

/**
 * 어떠한 수 N이 1이 주어질 때 다음의 두 과정 중 하나를 반복적으로 선택하여 수행할 때, 최소 횟수를 구하기
 * 1. N에서 1을 뺸다
 * 2. N을 K로 나눈다
 * 단, 두 번째 연산은 N이 K로 나누어 떨어절 때만 가능하다
 */

public class GreedyExample2 {

    public static void main(String[] args) {
        logic(10, 5);
    }

    public static void logic(int n, int k) {

        int cnt = 0;

        while (n != 1) {

            n -= 1;
            cnt ++;

            if (n > k && n % k == 0) {
                n = n / k;
                cnt ++;
            }
        }

        System.out.println(cnt);
    }

}
