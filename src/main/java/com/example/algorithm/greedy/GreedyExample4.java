package com.example.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 보물(백준 1026)
 * 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
 *
 * 재정렬하여 최솟값을 출력하는 함수를 작성하라
 *
 */
public class GreedyExample4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(logic());
    }

    public static int logic () {

        int cnt = sc.nextInt();
        Integer arrA [] = new Integer [cnt];
        Integer arrB [] = new Integer [cnt];

        for(int i =0; i<cnt; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int i =0; i<cnt; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        int result = 0;
        for (int i=0; i < cnt; i++) {
            result += arrA[i] * arrB[i];
        }

        return result;
    }
}
