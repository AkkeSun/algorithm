package com.example.algorithm.graph;

import org.springframework.beans.factory.annotation.Value;

import java.util.*;

/**
 * 특정 거리의 도시 찾기 (백준 18352)
 * 없다면 -1 리턴
 *
 * 입력 :
 * 4 4 2 1 -> 도시 개수, 도로 개수, 거리정보, 출발도시의 번호
 * 1 2
 * 1 3
 * 2 3
 * 2 4
 *
 * 츨력 :
 * 4
 *
 * 입력 :
 * 4 4 1 1
 * 1 2
 * 1 3
 * 2 3
 * 2 4
 *
 * 출력
 * 2
 * 3
 *
 *
 * 입력 :
 *  4 3 2 1
 * 1 2
 * 1 3
 * 1 4
 *
 * 출력 :
 * -1
 *
 * 어떤 조건을 가져아하는가?
 * 타겟 숫자만큼 이동이 가능해야한다.
 *
 *
 */
public class GraphExample8 {

    static ArrayList <Integer> [] graph;
    static int N, K, X, S;
    static Queue <Integer> q = new LinkedList();

    static ArrayList<Integer> result = new ArrayList<>();

    public static void makeGraph () {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 도시 갯수
        K = sc.nextInt(); // 도로 갯수
        X = sc.nextInt(); // 거리 정보
        S = sc.nextInt(); // 출발도시의 번호

        graph = new ArrayList[N+1];
        for(int i =0; i<graph.length; i++) {
            graph[i] = new ArrayList();
        }

        for(int i = 0 ; i<K; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            graph[to].add(from);
        }
    }

    static int cnt = 0;
    public static void bfs(int start) {
        q.offer(start);

        while(!q.isEmpty()) {

            Integer node = q.poll();

            // 하위 노드가 있을때만 값을 출력합니다.
            if(graph[node].size() > 0) {
                cnt ++;

                // cnt가 타겟 거리와 같다면 하위 노드를 저장 후 break;
                if(cnt == K) {
                    for(int i =0 ; i<graph[node].size(); i++) {
                        int inNode = graph[node].get(i);
                        result.add(inNode);
                    }
                    break;
                }

                for(int i =0 ; i<graph[node].size(); i++) {
                    int inNode = graph[node].get(i);

                }

            }
        }



    }





    public static void main(String[] args) {
        makeGraph();
    }




}












