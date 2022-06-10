package com.example.algorithm.graph;

import java.util.*;

/**
 * 바이러스 (백준 2606)
 * 그래프와 타겟 노드가 주어질 때 접속 가능한 모든 노드를 구하여라
 * 입력 : 7, 6, 1, 2, 2, 3, 1, 5, 5, 2, 5, 6, 4, 7
 */
public class GraphExample4 {

    static boolean visited [];

    // 무방향 그래프 만들기
    static ArrayList<Integer> graph [];

    // bfs 를 다루기 위한 Queue
    static Queue <Integer> q = new LinkedList();

    public static void makeGraph () {

        Scanner in = new Scanner(System.in);
        int comCnt = Integer.parseInt(in.next());

        graph = new ArrayList[comCnt+1];
        visited = new boolean[comCnt+1];

        // 초기화
        for (int i = 0; i<comCnt + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int nodeLine = Integer.parseInt(in.next());

        for (int j = 0; j < nodeLine; j++){

            int node1 = Integer.parseInt(in.next());
            int node2 = Integer.parseInt(in.next());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }
    static int cnt = -1;
    public static void dfs (int x) {

        // 방문처리 
        visited[x] = true;
        cnt ++;
    
        // 인접노드 체크 후 방문하지 않았다면 방문처리
        List<Integer> arr = graph[x];
        for (Integer y : arr) {
            if(!visited[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs (int x) {

        // 시작 노드를 queue 에 담은 후 방문처리
        q.offer(x);
        visited[x] = true;
        cnt ++;

        // queue 가 빌 때 까지 반복
        while(!q.isEmpty())
        {
            // 처음에 넣은 queue 를 꺼낸다
            Integer y = q.poll();

            // 인접 노드 조사
            for( int i = 0; i < graph[y].size(); i++) {

                Integer k = graph[y].get(i);

                // 처음 방문시에만 방문처리
                if(!visited[k]) {
                    q.offer(k);
                    visited[k] = true;
                    cnt++;
                }
            }

        }

    }

    public static void main(String[] args) {
        makeGraph();
        bfs(1);
        // dfs(1);
        System.out.println("cnt : " + cnt);
    }
}
