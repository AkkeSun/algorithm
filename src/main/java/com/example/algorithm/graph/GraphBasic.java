package com.example.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * stack & queue 에 대한 이해
 */
public class GraphBasic {

    public static void main(String[] args) {
        stack();
        queue();
    }

    public static void stack() {

        System.out.println("=== stack ===");

        Stack s = new Stack();
        s.push("item1");
        s.push("item2");
        s.push("item3");

        while(!s.empty()) {
            System.out.println(s.peek()); // 맨 위에 원소 출력
            s.pop(); // 맨 위에 원소 삭제;
        }
    }

    public static void queue() {

        System.out.println("=== queue ===");

        Queue queue = new LinkedList();

        queue.offer("item1");
        queue.offer("item2");
        queue.offer("item3");

        while(!queue.isEmpty()) {
            System.out.println(queue.poll()); // 먼저 들어온 원소부터 출력 ( 꺼냄과 동시 출력 )
        }
    }
}
