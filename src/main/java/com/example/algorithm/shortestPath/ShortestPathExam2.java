package com.example.algorithm.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 어떤 나라에는 N개의 도시가 있다.
 * 각 도시의 번호와 통로가 설치되어있는 정보가 주어졌을 때,
 * 도시 C에서 보낸 메시지를 받게 되는 도시의 개수는 총 몇 개이며
 * 도시들이 모두 메시지를 받는 데까지 걸리는 시간은 얼마인지 출력하라
 *
 * 입력 :
 * 3, 2, 1 -> 도시의 개수, 통로의 개수, 도시 C
 * 1, 2, 4 -> 도시 X, 도시 Y, 거리 Z
 * 1, 3, 2
 *
 * 출력 :
 * 2, 4
 */
public class ShortestPathExam2 {

    static ArrayList<Node> graph [] ;

    static int minLength [] ;

    static int INF = (int)1e9;

    static int cityCnt, cityLoad, targetCity;

    public static void makeGraph () {
        Scanner sc = new Scanner(System.in);

        cityCnt = sc.nextInt();
        cityLoad = sc.nextInt();
        targetCity = sc.nextInt();

        graph = new ArrayList[cityCnt+1];

        for (int i=0; i<cityCnt+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<cityLoad; i++) {
            int targetA = sc.nextInt();
            int targetB = sc.nextInt();
            int length = sc.nextInt();
            graph[targetA].add(new Node(targetB, length));
        }

        minLength = new int[cityCnt +1];
        Arrays.fill(minLength, INF);

    }

    public static void dijkstra(int start) {
        
        // 시작지점 초기화
        minLength[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while(!q.isEmpty()) {

            Node node = q.poll();
            int index = node.getIndex();

            if(index != targetCity && minLength[index] == INF) continue;

            for (int i = 0; i < graph[index].size(); i++) {
                Node childNode = graph[index].get(i);
                int childIndex = childNode.getIndex();
                int childDistance = childNode.getDistance();

                int length = childDistance + minLength[index];

                System.out.println("부모노드 : " + index);
                System.out.println("최소길이 : " + minLength[index]);

                System.out.println("자식노드 : " + childIndex);
                System.out.println("자식최소 : " + minLength[childIndex]);
                System.out.println("거친경우 : " + length);


                if(length < minLength[childIndex]) {
                    minLength[childIndex] = length;
                    q.offer(new Node(childIndex, length));
                }

                System.out.println("결과 : " + minLength[childIndex]);
                System.out.println("=============================");
            }
        }

    }


    public static void main(String[] args) {
        makeGraph();
        dijkstra(targetCity);
        int maxTime = 0;
        int cityCntResult = 0;

        for( int i =0 ; i <minLength.length; i++) {

            if(minLength[i] != INF && minLength[i] != 0) {
                cityCntResult ++;
                if(maxTime < minLength[i]) {
                    maxTime = minLength[i];
                }
            }
        }
        System.out.println(cityCntResult);
        System.out.println(maxTime);
    }




}
