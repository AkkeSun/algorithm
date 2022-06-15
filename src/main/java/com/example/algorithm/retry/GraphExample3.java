package com.example.algorithm.retry;

/**
 * 백준 2667
 * 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * 완전탐색 (bfs, dfs)
 *
 * 출력 : 단지수, 단지에 속하는 집의 수 (오름차)
 *
 * 필요한게 무엇일까
 * 1. 검색할 때 마다 cnt 올려주기
 * 2. dfs 리턴값이 true 면 단지수를 올려주고 cnt를 변수에 저장한다.
 */

public class GraphExample3 {

     static int [][] map = {
            {0, 1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0 ,1},
            {0, 0, 0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 0}
    };

    // 카운트한 단지별 아파트수를 저장하는 변수
    static ArrayList<Integer> apart = new ArrayList<>();
    static int aptCnt = 0;

    public static boolean dfs (int x, int y) {

        // 좌표가 map 을 넘어가지 않는 경우에만 수행
        if(!(x < 0 || y < 0 || x>=map.length || y>=map.length)) {

            // 아파트라면
            if(map[x][y] == 1) {

                // 방문처리
                map[x][y] = 0;

                // 아파트 수 늘려주기
                aptCnt++;

                // 네 방향 검색
                dfs(x-1, y);
                dfs(x+1, y);
                dfs(x, y-1);
                dfs(x, y+1);

                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        for(int i =0 ; i<map.length; i++) {
            for(int j = 0; j<map.length; j++) {

                // 시작 좌표가 아파트인 경우에만 로직을 수행
                if(map[i][j] == 1) {

                    // 재귀를 빠져나왔다면 하나의 단지
                    if(dfs(i,j)) {
                        apart.add(aptCnt);
                        aptCnt = 0;
                    }
                }
            }
        }

        System.out.println(apart.size());
        Collections.sort(apart);
        System.out.println(apart);

    }
}
