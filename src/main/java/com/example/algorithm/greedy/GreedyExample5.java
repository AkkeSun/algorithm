package com.example.algorithm.greedy;

import java.util.Scanner;

/**
 * 주유소 (백준 13305)
 * 어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 있다.
 * 편의상 일직선을 수평 방향으로 두자.
 * 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동하려고 한다.
 * 인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다. 도로 길이의 단위는 km를 사용한다.
 *
 * 각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아
 * 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
 *
 * 입력 :
 * 4 -> 도시 갯수
 * 2 3 1 -> 각 도시간 거리
 * 5 2 4 1 -> 도시의 기름값
 *
 * 출력 :
 * 18
 *
 * 입력 :
 * 4
 * 3 3 4
 * 1 1 1 1
 *
 * 출력 : 10
 */
public class GreedyExample5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int city [];
        int cityLength [];
        int cnt = sc.nextInt();

        city = new int[cnt];
        cityLength = new int[cnt-1];

        for(int i =0 ;i<cnt-1; i++) {
            cityLength[i] = sc.nextInt();
        }
        for(int i =0 ;i<cnt; i++) {
            city[i] = sc.nextInt();
        }

        int tmp = city[0];
        int tmpIndex = 0;

        // 기름 최저값 찾기
        for(int i = 1; i<cnt-1; i++ ){

            int cityPrice = city[i];
            if( cityPrice < tmp ) {
                tmp = city[i];
                tmpIndex = i;
            }
        }

        int price = 0 ;
        for(int i =0; i<tmpIndex; i++) {
            price += city[0] * cityLength[i];
        }

        for(int i =tmpIndex; i<cityLength.length; i++) {
            price += city[tmpIndex] * cityLength[i];
        }

        System.out.println(price);

    }

}
