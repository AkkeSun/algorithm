package com.example.algorithm.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

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
 * 4 3 2 1
 * 1 2
 * 1 3
 * 1 4
 *
 * 출력 :
 * -1
 *
 *
 */
class Node2 implements Comparable<Node2> {

    private int index;
    private int distinct;


    public Node2(int index, int distinct) {
        this.index = index;
        this.distinct = distinct;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistinct() {
        return this.distinct;
    }

    @Override
    public int compareTo(Node2 node2) {

        if(this.distinct < node2.distinct  )
            return -1;
        return 0;
    }
}

public class ShortestPathExam1 {

    static int cityCnt, loadCnt, targetLength, targetCity;

    static ArrayList<Node2> graph [] ;

    static int minLength [] ;

    static int INF = (int)1e9;

    static Scanner sc = new Scanner(System.in);


    public static void makeGraph () {

        cityCnt = sc.nextInt();
        loadCnt = sc.nextInt();
        targetLength = sc.nextInt();
        targetCity = sc.nextInt();

        // == 그래프 초기화 ====
        graph = new ArrayList[cityCnt + 1];

        for(int i =0; i<=cityCnt; i++) {
            graph[i] = new ArrayList<Node2>();
        }

        for(int i =0; i<loadCnt; i++) {

            int start = sc.nextInt();
            int end = sc.nextInt();
            // start 에서 end 까지 1의 거리가 소요된다고 가정
            graph[start].add(new Node2(end, 1));
        }

        // 최단거리 배열 초기화
        minLength = new int[cityCnt + 1];
        Arrays.fill(minLength, INF);

    }


    public static void dijkstra(int start){

        // 시작지점 최단거리 초기화
        minLength[start] = 0;

        // 우선순위 큐에 시작지점 저장
        PriorityQueue<Node2> q = new PriorityQueue<>();
        q.offer(new Node2(start, 0));

        while(!q.isEmpty()) {

            Node2 node = q.poll();
            int index = node.getIndex();

            // 이미 방문처리되었다면 무시
            if(index != targetCity && minLength[index] == INF) continue;

            // 인접 노드 조사
            for(int i=0 ; i<graph[index].size(); i++) {

                Node2 childNode = graph[index].get(i);
                int childIndex = childNode.getIndex();
                int childDistinct = childNode.getDistinct();

                int length = minLength[index] + childDistinct;

                System.out.println("부모노드 : " + index);
                System.out.println("최소길이 : " + minLength[index]);

                System.out.println("자식노드 : " + childIndex);
                System.out.println("자식최소 : " + minLength[childIndex]);
                System.out.println("거친경우 : " + length);

                // 부모 노드를 거친 거리가 최소거리라면
                if(length < minLength[childIndex]) {
                    minLength[childIndex] = length;
                    q.offer(new Node2(childIndex, length));
                }

                System.out.println("결과 : " + minLength[index]);
                System.out.println("=============================");
            }
        }

    }

    public static void main(String[] args) {

        makeGraph();
        dijkstra(targetCity);

        boolean result = false;
        for(int i=0; i<minLength.length; i++) {
            if(minLength[i] == targetLength) {
                System.out.println(i);
                result =true;
            }
        }

        if(!result)
            System.out.println(-1);
    }

}

