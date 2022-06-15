package com.example.algorithm.retry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 바이러스 (백준 2606)
 * 그래프와 타겟 노드가 주어질 때 접속 가능한 모든 노드를 구하여라
 * 입력 :
 * 7, 6,
 * 1, 2, 2, 3, 1, 5, 5, 2, 5, 6, 4, 7
 *
 * 출력 :
 * 4
 */
public class GraphExample4 {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> graph [];
    static boolean visited [];

    static int result = 0;
    static int nodeCnt, nodeLine;

    static Queue <Integer> q = new LinkedList();
    public static void makeGraph() {

        nodeCnt = sc.nextInt();
        graph = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];

        for(int i = 0 ; i < nodeCnt + 1; i++ ) {
            graph[i] = new ArrayList<>();
        }

        nodeLine = sc.nextInt();
        for(int i = 0; i < nodeLine; i++) {
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();
            graph[nodeA].add(nodeB);
        }
    }

    public static void dfs(int x) {

        // 방문처리
        visited[x] = true;

        // 인접노드 검색
        for(int i = 0; i<graph[x].size(); i++ ) {
            Integer node = graph[x].get(i);

            // 방문하지 않았다면 재귀
            if(!visited[node]) {
                result++;
                dfs(node);
            }
        }
    }

    public static void bfs(int x) {

        // 큐에 입력
        q.offer(x);
        visited[x] = true;

        // 큐가 빌 때 까지 실행
        while(!q.isEmpty()) {
            Integer y = q.poll(); // 큐의 최상위 값 꺼내기

            for(int i = 0; i<graph[y].size(); i++) {

                Integer node = graph[y].get(i);
                if(!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                    result ++;
                }
            }
        }


    }


    public static void main(String[] args) {
        makeGraph();
        bfs(1);
        System.out.println(result);
    }

}
