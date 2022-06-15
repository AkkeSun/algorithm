package com.example.algorithm.retry;



/**
 * 음료수 얼려먹기
 * N x M 크기의 얼음틀이 있습니다.
 * 구멍이 뚫려있는 부분은 0, 칸막이가 있는 부분은 1로 표시됩니다.
 * N,M과 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림 갯수를 구하시오
 */
public class GraphExample1 {

    public static int n = 4;
    public static int m = 5;
    public static int[][] graph =  { {0,0,1,1,0},
                                     {0,0,0,1,1},
                                     {1,1,1,1,1},
                                     {0,0,0,0,0} };

    public static boolean dfs (int x, int y) {

        if(x < 0 || y <0 || x >= n || y >= m)
            return false;

        if(graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int cnt = 0;

        for(int i =0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(dfs(i,j))
                    cnt ++;
            }
        }

        System.out.println(cnt);
    }

}
