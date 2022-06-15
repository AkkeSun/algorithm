package com.example.algorithm.retry;


import java.util.*;

/**
 * 미로탈출 문제
 * N x M 크기의 직사각형 형태의 미로에 갇혔습니다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈줄해야합니다.
 * 시작 위치는 (1,1)이며 미로의 출구는 (N,M) 위치에 존재합니다.
 * 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어있습니다.
 * 이 때 탈출하기 위해 움직여야하는 최소 칸의 갯수를 구하세요. (칸을 셀 때에는 시작 칸과 마지막 칸을 모두 포함해서 계산합니다)
 */
public class GraphExample2 {

    static int n = 4;
    static int m = 5;
    static int [][] graph =  {  {1,1,1,1,0},
                                {0,1,0,1,1},
                                {1,0,1,0,1},
                                {0,0,0,1,1}
                             };
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static Queue < int [] > queue = new LinkedList();


    public static void bfs(int startX, int startY) {

        // 기본 좌표 queue 에 등록
        int xy [] = {startX, startY};
        queue.offer(xy);
        
        while(!queue.isEmpty()) {

            // queue 에서 값을 꺼낸다
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            // 네 방향 검색
            for(int i =0 ; i<4; i++) {

                int nx = dx[i] + x;
                int ny = dy[i] + y;

                // map 을 넘어가면 패스
                if(nx < 0 || ny <0 || nx >=n || ny >=m)
                    continue;;

                // 접근 가능한데 접근하지 않았다면 부모 값을 더해준다 (이동)
                if(graph[nx][ny] == 1)
                    graph[nx][ny] += graph[x][y];
            }
        }
    }

    public static void main(String[] args) {
        for(int i =0; i < n; i++) {
            for (int j =0; j< m; j++) {
                bfs(i, j);
            }
        }

        System.out.println(graph[n-1][m-1]);
    }




}
