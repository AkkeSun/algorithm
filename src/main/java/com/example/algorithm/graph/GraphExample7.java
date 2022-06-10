package com.example.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 촌수 계산 (백준 2644)
 * 촌수를 출력하라. 관련없는 경우 -1을 출력하라
 *
 * 입력 1:
 * 9 -> 전체 사람수
 * 7 3 -> 촌수 계산할 번호
 * 7 -> 부모자식관계의 수
 * 1 2
 * 1 3
 * 2 7
 * 2 8
 * 2 9
 * 4 5
 * 4 6
 *
 * 출력 1:
 * 3
 *
 * 입력 2:
 * 9
 * 8 6
 * 7
 * 1 2
 * 1 3
 * 2 7
 * 2 8
 * 2 9
 * 4 5
 * 4 6
 *
 * 출력 2 :
 * -1
 */
public class GraphExample7 {

    static boolean visited [];

    // 인접 리스트 생성
    static ArrayList<Integer> graph [];

    // 노드 갯수
    static int nodeCnt;

    // 노드 연결 수
    static int nodeLine;

    // 촌수 계산할 타겟
    static int targetA, targetB;

    // 촌수
    static int con;

    // 검색 완료 유무
    static boolean success;

    static Scanner sc = new Scanner(System.in);

    public static void makeGraph() {

        nodeCnt = Integer.parseInt(sc.next());
        targetA = Integer.parseInt(sc.next());
        targetB = Integer.parseInt(sc.next());
        nodeLine = Integer.parseInt(sc.next());

        graph = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];

        for(int j=1; j < graph.length; j++) {
            graph[j] = new ArrayList<>();
        }

        for(int i=0; i<nodeLine; i++) {
            int nodeA = Integer.parseInt(sc.next());
            int nodeB = Integer.parseInt(sc.next());

            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
    }

    public static int dfs(int x) {

        // 방문처리 및 현재값 셋팅
        visited[x] = true;

        for(int i=0; i<graph[x].size(); i++){
            if(!success) {
                int node = graph[x].get(i);

                // 방문하지 않았다면 촌수를 늘리고 방문처리 (재귀)
                if (!visited[node]) {
                    con++;
                    if (node == targetB) {
                        success = true;
                    }
                    dfs(node);
                }
            }
        }

        if(success)
            return con;
        else
            return -1;
    }


    public static void main(String[] args) {

        makeGraph();
        System.out.println(dfs(targetA));

    }
}
