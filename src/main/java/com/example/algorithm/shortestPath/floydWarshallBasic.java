package com.example.algorithm.shortestPath;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [플로이드 - 워셜 알고리즘]
 *  => 모든 노드에서 다른 모든 노드까지의 최단경로를 계산하는 알고리즘
 *  => 다익스트라와 다르게 매 단계마다 방문하지 않은 노드 중에 최단거리를 갖는 노드를 찾는 과정이 필요없다
 *  => 2차원 배열에 최단거리 정보를 저장한다.
 *
 *
 *  1. 초기 테이블 설정 ( 다이렉트로 가는 길이 없으면 무한 표시 )
 *   출발\도착   1    2    3    4
 *          1   0    4   무한   6
 *          2   3    0    7    무한
 *          3   5    무한  0    4
 *          4   무한  무한  2    0
 *
 *  2. 이동하며 최단경로 갱신
 *
 */
public class floydWarshallBasic {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정

    // 노드의 개수(N), 간선의 개수(M)
    public static int n, m;

    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 최단거리를 무한으로 초기화
        for(int i =0 ; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 설정
        for (int i =0; i<= n; i++) {
            for(int j = 1; j<=n; j++) {
                if(i ==j ) graph[i][j] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 플로이드 워쉘 알고리즘 실행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }


    }
}
