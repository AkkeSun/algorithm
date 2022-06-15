package com.example.algorithm.graph;

import java.util.*;

/**
 * 연결 요소의 개수 (백준 11724)
 * 무방향그래프가 주어졌을 때 연결요소(그룹)의 개수를 구하는 프로그램을 작성하시오
 * N : 정점의 갯수   M : 간선의 갯수
 *
 * 입력 1:
 * 6 5
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 *
 * 출력 1:
 * 2
 *
 * 입력 2:
 * 6 8
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 * 5 4
 * 2 4
 * 2 3
 *
 * 출력 2 :
 * 1
 */
public class GraphExample5 {

    static boolean visited [];

    // 인접 리스트 생성
    static ArrayList<Integer> graph [];

    static int n, m;


    static void makeGraph() {

        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        m = Integer.parseInt(sc.next());

        for(int j = 0 ; j < m; j++) {

            int nodeA = Integer.parseInt(sc.next());
            int nodeB = Integer.parseInt(sc.next());

            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
    }

    public static void dfs(int x) {

        // 방문처리
        visited[x] = true;

        // 인접 노드 조사
        for(int i = 0; i<graph[x].size(); i++) {

            Integer y = graph[x].get(i);

            // 방문하지 않았다면 방문처리 (재귀)
            if(!visited[y]){
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {

        makeGraph();
        int cnt = 0;

        // node 갯수만큼 반복 (!!! 방문 안한 경우 dfs 실행 !!!)
        for( int i = 1; i <n + 1; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
