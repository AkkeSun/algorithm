package com.example.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로탈출 문제
 * N x M 크기의 직사각형 형태의 미로에 갇혔습니다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈줄해야합니다.
 * 시작 위치는 (1,1)이며 미로의 출구는 (N,M) 위치에 존재합니다.
 * 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어있습니다.
 * 이 때 탈출하기 위해 움직여야하는 최소 칸의 갯수를 구하세요. (칸을 셀 때에는 시작 칸과 마지막 칸을 모두 포함해서 계산합니다)
 */

class Node {
    private int x;
    private int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }
}

public class GraphExample2 {

    public static int n = 4;
    public static int m = 5;
    public static int [][] graph =  {  {1,1,1,1,0},
                                       {0,1,0,1,1},
                                       {1,0,1,0,1},
                                       {0,0,0,1,1}
                                    };

    // 일단 이동이 있으면 방향벡터를 사용한다 (상하좌우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};


    public static void main(String[] args) {
        System.out.println(bfs(0,0));
    }

    public static int bfs (int x, int y) {

        Queue <Node> queue = new LinkedList();

        // queue 에 등록
        queue.offer(new Node(x, y));

        while(!queue.isEmpty()) {

            // 좌표 값 가져오기
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            // 네 방향 조사
            for (int i=0; i<4; i++) {
                // 이동
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 괴물인 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록 (좌표 값을 늘린다)
                if(graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1; // 이동한 좌표에 1을 더한다
                    queue.offer(new Node(nx, ny));   // queue 에 저장
                }
            }
        }

        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

}
