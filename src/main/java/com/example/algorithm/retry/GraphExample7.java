package com.example.algorithm.retry;

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



    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int personCnt, targetA, targetB, size, con;
    static boolean btn = false;

    public static void makeGraph() {

        Scanner sc = new Scanner(System.in);
        personCnt = sc.nextInt();
        targetA = sc.nextInt();
        targetB = sc.nextInt();
        size = sc.nextInt();

        graph = new ArrayList[personCnt + 1];
        visited = new boolean[personCnt + 1];
        con = 0;

        for(int i =0 ; i <graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int j =0; j<size; j++) {
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();

            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
    }

    public static void dfs (int target) {
        // 방문처리
        visited[target]= true;

        if(target != targetB) {
            // 인접노드 검색
            for(int i =0 ; i < graph[target].size(); i ++) {
                Integer node = graph[target].get(i);

                // 방문 안했다면
                if(!visited[node] && !btn) {
                    con ++;
                    dfs(node);
                }
            }
        }
        else {
            btn = true;
        }

    }


    public static void main(String[] args) {
        makeGraph();
        dfs(targetA);
        if(btn)
            System.out.println(con);
        else
            System.out.println(-1);
    }

}
