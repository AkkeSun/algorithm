package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 키패드 누르기 (프로그래머스 67256)
 */
public class Test67256 {


    public static int[][] graph = new int[13][13];
    public static String solution(int[] numbers, String hand) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(2, new ArrayList<>(Arrays.asList(0,1)));
        map.put(5, new ArrayList<>(Arrays.asList(1,1)));
        map.put(8, new ArrayList<>(Arrays.asList(2,1)));
        map.put(11, new ArrayList<>(Arrays.asList(3,1)));

        int nowLX = 3;
        int nowLY = 0;
        int nowRX = 3;
        int nowRY = 2;

        String answer = "";
        for(int i = 0; i < numbers.length; i++)
        {
            int number = numbers[i];

            // 왼쪽 버튼
            if(number == 1 ) {
                nowLX = 0; nowLY = 0; answer += "L";
            } else if(number == 4) {
                nowLX = 1; nowLY = 0; answer += "L";
            } else if(number == 7) {
                nowLX = 2; nowLY = 0; answer += "L";
            }
            // 오른쪽 버튼
            else if(number == 3 ) {
                nowRX = 0; nowRY = 2; answer += "R";
            } else if(number == 6) {
                nowRX = 1; nowRY = 2; answer += "R";
            } else if(number == 9) {
                nowRX = 2; nowRY = 2; answer += "R";
            }

            // 중앙버튼
            else
            {

                if(number == 0)
                    number = 11;

                ArrayList<Integer> target = map.get(number);

                int rX = 0;
                int rY = 0;
                int lX = 0;
                int lY = 0;

                // 오른손 계산
                if(target.get(0) > nowRX)
                    rX = target.get(0) - nowRX;
                else
                    rX = nowRX - target.get(0);
                if(target.get(1) > nowRY)
                    rY = target.get(1) - nowRY;
                else
                    rY = nowRY - target.get(1);
                int rightValue = rX + rY;

                // 왼손 계산
                if(target.get(0) > nowLX)
                    lX = target.get(0) - nowLX;
                else
                    lX = nowLX - target.get(0);
                if(target.get(1) > nowLY)
                    lY = target.get(1) - nowLY;
                else
                    lY = nowLY - target.get(1);
                int leftValue = lX + lY;


                String check = "R";
                if(leftValue < rightValue || (leftValue == rightValue && hand.equals("left")))
                    check = "L";
                if(check.equals("R")) {
                    nowRX = target.get(0);
                    nowRY = target.get(1);
                }
                else {
                    nowLX = target.get(0);
                    nowLY = target.get(1);
                }
                answer += check;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int numbers [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        String solution = solution(numbers, hand);
        System.out.println(solution);

    }


}
