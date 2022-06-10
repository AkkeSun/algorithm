package com.example.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  * BFS (Breadth First Search)
 *  * 가까운 노드부터 우선적으로 탐색. 큐를 사용
 *  * 1. 탐색 시작 노드를 큐에 삽입하고 방문처리를 한다.
 *  * 2. 큐에서 노드를 꺼낸 뒤 해당노드의 인접 노드 중에서 방문하지 않는 노드를 모두 큐에 삽입하고 방문처리
 *  * 3. 반복
 */
public class Bfs {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static Queue <Integer>queue = new LinkedList<>();
    public static boolean visited[] = new boolean[9];

    public static void main(String[] args) {
        makeGraph();
        bfs(1);
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

    public static void bfs(int x) {

        // 시작 노드를 queue 에 입력 후 방문처리
        queue.offer(x);
        visited[x] = true;

        // queue 가 빌 때 까지 반복
        while(!queue.isEmpty())
        {
            // 가장 처음 넣은 값을 queue 에서 꺼낸다
            int target = queue.poll();
            System.out.println("방문 : " + target);

            for( int i =0; i<graph.get(target).size(); i++)
            {
                // 인접노드를 방문하지 않았다면 queue 에 넣은 후 방문처리한다
                int y = graph.get(target).get(i);
                if(!visited[y]){
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

}
