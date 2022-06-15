package com.example.algorithm.retry;

import java.util.ArrayList;
import java.util.HashMap;
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


    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static HashMap<Integer, Integer> result = new HashMap<>(); // child, parent 입력
    static int nodeCnt;

    public static void makeGraph() {

        Scanner sc = new Scanner(System.in);
        nodeCnt = sc.nextInt();

        graph = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];

        for(int i = 0; i<nodeCnt + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int j = 0; j<nodeCnt-1; j ++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

    }

    public static void dfs (int x) {

        for(int i =0; i<graph[x].size(); i++) {
            Integer node = graph[x].get(i);

            // 부모노드 정보가 등록되지 않았다면 (방문하지 않았다면)
            if(result.get(node) == null && node != 1){
                result.put(node, x);
                dfs(node);
            }
        }

    }

    public static void main(String[] args) {
        makeGraph();
        dfs(1);
        for(int i = 2 ; i<= nodeCnt; i++) {
            System.out.println(result.get(i));
        }
    }

}
