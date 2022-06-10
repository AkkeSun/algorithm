package com.example.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  * DFS (Depth First Search)
 *  * 깊이 우선 탐색. 스택 (혹은 재귀함수)을 사용
 *  * 1. 탐색 시작 노드를 스택에 삽입하고 방문처리
 *  * 2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 방문처리
 *  * 3. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼내기
 *  * 4. 반복
 */
public class Dfs {
    public static boolean visited[] = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {

        makeGraph();
        dfs(1);

    }



    // 트리 그래프는 2차원 Array 로 제작합니다.
    public static ArrayList<ArrayList<Integer>> makeGraph() {

        // 그래프 초기화
        for( int i = 0; i< 9; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        return graph;
    }


    public static void dfs(int x) {

        //방문처리
        visited[x] = true;
        System.out.println("방문 : " + x);

        // 재귀
        ArrayList<ArrayList<Integer>> graph = makeGraph();
        for (int i = 0; i < graph.get(x).size(); i++) {
            if (!visited[graph.get(x).get(i)])
                dfs(graph.get(x).get(i));
        }
    }


}
