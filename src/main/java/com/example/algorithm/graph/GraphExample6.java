package com.example.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 트리의 부모 찾기 (백준 11725)
 * 루트 없는 트리가 주어진다.
 * 이때, 트리의 루트를 1이라고 정했을 때,
 * 각 노드의 부모를 구하는 프로그램을 작성하시오. (2번 노드부터 순서대로)
 *
 * 입력 1:
 * 7 -> 총 노드의 수
 * 1 6
 * 6 3
 * 3 5
 * 4 1
 * 2 4
 * 4 7
 *
 * 출력 1:
 * 4
 * 6
 * 1
 * 3
 * 1
 * 4
 *
 * 입력 2:
 * 12
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * 3 6
 * 4 7
 * 4 8
 * 5 9
 * 5 10
 * 6 11
 * 6 12
 *
 * 출력 2 :
 * 1
 * 1
 * 2
 * 3
 * 3
 * 4
 * 4
 * 5
 * 5
 * 6
 * 6
 */
public class GraphExample6 {

    static boolean visited [];

    // 인접 리스트 생성
    static ArrayList<Integer> graph [];

    // 부모 노드 값 저장
    static int pNode [];

    // 노드 갯수
    static int nodeCnt;
    
    public static void makeGraph() {

        Scanner sc = new Scanner(System.in);
        nodeCnt = Integer.parseInt(sc.next());

        pNode = new int[nodeCnt + 1];
        graph = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];

        for(int j=1; j < graph.length; j++) {
            graph[j] = new ArrayList<>();
        }

        for(int i=0; i<nodeCnt-1; i++) {
            int nodeA = Integer.parseInt(sc.next());
            int nodeB = Integer.parseInt(sc.next());

            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
    }

    public static void dfs(int x) {

        // 방문 처리
        visited[x] = true;

        // 입력값의 인접 노드를 검색
        for(int i =0; i<graph[x].size(); i++) {

            Integer cNode = graph[x].get(i);

            // 방문하지 않았다면 부모노드 등록 후 재귀
            if(!visited[cNode]) {
                pNode[cNode] = x;
                dfs(cNode);
            }
        }
    }


    public static void main(String[] args) {
        makeGraph();

        for(int i =1 ; i<nodeCnt+1; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        for(int j=2; j<pNode.length; j++) {
            System.out.println(pNode[j]);
        }


    }
}
