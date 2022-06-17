package com.example.algorithm.dijkstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘 (최단경로 구하기)
 * [ 다양한 문제 상횡 ]
 * 1. 한 지점에서 다른 한 지점까지의 최단경로
 * 2. 한 지점에서 특정 경로까지 도달가능한 노드
 * 3. 모든 지점에서 다른 모든 지점까지의 최단경로
 *
 * [ 알고리즘 ]
 * 1. 출발 노드 설정
 * 2. 최단 거리 테이블 초기화
 * 3. 방문하지 않은 노드 중에서 최단거리가 가장 짧은 노드를 선택
 * 4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산해서 최단 거리 테이블을 갱신
 * 5. 3번과 4번을 반복
 *
 * [ 어떻게 코딩할까 ]
 * 총 노드가 5개이고 1번 노드부터 조사한다고 할 때
 *
 * 노드번호   1    2    3    4    5
 * 거리      0   무한  무한  무한  무한
 *
 * 으로 초기화 해 준 다음에 이동해가면서 최단 값을 갱신해준다
 * return -> 최단거리 테이블
 *
 *
 *
 * 입력 :
 * 3, 3, 1 -> 노드 갯수, 관계 갯수, 시작 값
 * 1, 2, 3 -> A노드, B노드, 두 노드의 이동비용
 * 2, 3, 4
 * 1, 3, 8
 *
 * 출력 :
 * 0
 * 3
 * 7
 *
 *
 *
 * 입력 :
 * 6, 11, 1 -> 노드 갯수, 관계 갯수, 시작 값
 * 1, 2, 2 -> A노드, B노드, 두 노드의 이동비용
 * 1, 3, 5
 * 1, 4, 1
 * 2, 3, 3
 * 2, 4, 2
 * 3, 2, 3
 * 3, 6, 5
 * 4, 3, 3
 * 4, 5, 1
 * 5, 3, 1
 * 5, 6, 2
 *
 * 출력 :
 * 0
 * 2
 * 3
 * 1
 * 2
 * 4
 *
 */
class Node implements Comparable<Node> {

    private int index;    // 노드 번호
    private int distance; // 거리

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class DijkstraBasic {

    // 무한을 의미하는 값으로 10억을 설정
    public static final int INF = (int) 1e9;

    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    public static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 타겟노드 ~ 현재 노드까지의 최단 거리
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {

        // 우선순위 큐 : 우선순위를 먼저 결정하고 우선순위가 높은 엘리먼트가 먼저 나가는 구조 (tree 구조)
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 초기화 : 시작점이 타겟이므로 distance 0, 최소거리 0
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (now != start && d[now] == INF ) continue;
        
            // 인접 노드 확인
            for (int i = 0; i < graph.get(now).size(); i++) {

                Node checkNode = graph.get(now).get(i);

                // (타겟노드 ~ 부모노드 까지의 최소 거리) + (부모노드 ~ 자식노드 비용)
                int cost = d[now] + checkNode.getDistance();

                System.out.println("부모 노드 : " + now + " || 타겟노드 ~ 부모노드 까지의 최소 거리 : " + d[now]);
                System.out.println("자식 노드 : " + checkNode.getIndex() + " || 부모노드 ~ 자식노드 까지의 거리 : " + checkNode.getDistance());
                System.out.println("부모 노드를 거쳤을 때 비용 : " + cost + " || 현재 등록된 최소거리 : " + d[checkNode.getIndex()]);

                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[checkNode.getIndex()]) {
                    d[checkNode.getIndex()] = cost;   // 인접노드 최소거거리 초기화
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); // 결과 값을 queue 에 등록
                }

                System.out.println("결과 : " + d[checkNode.getIndex()]);
                System.out.println("===================================");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
