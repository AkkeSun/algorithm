package com.example.algorithm.graph;



/**
 * 음료수 얼려먹기
 * N x M 크기의 얼음틀이 있습니다.
 * 구멍이 뚫려있는 부분은 0, 칸막이가 있는 부분은 1로 표시됩니다.
 * N,M과 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림 갯수를 구하시오
 */
public class GraphExample1 {

    public static int n = 4;
    public static int m = 5;
    public static int[][] graph =  { {0,0,1,1,0}, {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0} };

    public static boolean dfs(int x, int y) {

        /**
         * 1 : 기둥. 방문한 곳으로 간주
         * 0 : 방문하지 않은곳으로 간주
         * 재귀를 돌면서 true 값을 출력해 아이스크림을 만든다 (이게 포인트! stack 이 쌓이고 쌓여서 가장 위에 값이 출력된다 )
         */

        // 범위를 벗어난다면
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }


        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int result = 0;
        for(int i = 0 ; i<n; i++) {
            for (int j = 0; j<m; j++){
                if(dfs(i, j))
                    result ++;
            }
        }

        System.out.println(result);
    }

}
