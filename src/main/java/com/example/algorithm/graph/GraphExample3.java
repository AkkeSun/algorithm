package com.example.algorithm.graph;

import java.util.*;

/**
 * 백준 2667
 * 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 */


/**
 * Logic
 * 1. 리턴 타입 : int ( 총 단지수 ), array (단지별 아파트 갯수)
 * 2. map 만큼 반복
 * 3. 4방향 탐색. 방문유무를 체크한 후 방문하지 않았고 1 이라면 재귀 ( 방문처리 )
 */
public class GraphExample3 {

    public static int [][] map = {
            {0, 1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0 ,1},
            {0, 0, 0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 0}
    };

    public  static int n = map.length;

    // 방문 유무
    public static boolean [][] visited = new boolean[7][7];

    // 이동벡터 (상하좌우)
    public static int dx [] = {-1, 1, 0, 0};
    public static int dy [] = {0, 0, -1, 1};

    // 아파트 단지
    public static int danzi = 0;

    // 최종 출력
    private static int[] aparts = new int[25*25];

    public static void main(String[] args) {

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    danzi++;
                    dfs(i,j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(danzi);
        for(int j = 0; j <aparts.length; j++) {
            if(aparts[j] != 0)
                System.out.println(aparts[j]);
        }

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        aparts[danzi]++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < n && ny < n){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
