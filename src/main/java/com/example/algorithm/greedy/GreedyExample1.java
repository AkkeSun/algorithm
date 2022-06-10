package com.example.algorithm.greedy;

/**
 * Greedy : 탐욕법
 * 현재 상화에서 가장 좋은 것만 고르는 방법 (최대값을 기준으로 처리)
 * 일반적인 상황에서 그리디 알고리즘은 최적의 상황을보장할 수 없을 때가 많지만
 * 코딩테스트에서의 대부분의 그리디 문제는 탐욕법으로 얻은 해가 최적의 해가 된다.
 */

// 주어진 값을 동전으로 돌려줄 때 최대 동전 갯수 구하기
public class GreedyExample1 {

    public static void main(String[] args) {
        logic(3850);
    }

    public static void logic (int money) {

            int result = 0;
            int [] coin = {500, 100, 50, 10};

            for (int i =0; i<4; i++) {
                result += money / coin[i];
                money = money % coin[i];
            }

            System.out.println(result);
        }

}
