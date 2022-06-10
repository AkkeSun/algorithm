package com.example.algorithm.implementation;

import org.springframework.stereotype.Service;

import java.util.Map;

public class ImplementationExample {



    /**
    * 구현
    * 머릿속에 있는 알고리즘을 소스코드로 바꾸는 과정
    * 1. 알고리즘은 간단한데 코드가 지나칠만큼 길어지는 문제
    * 2. 특정 소수점 자리까지 출력해야 하는 문제
    * 3. 문자열을 특정 기준에 따라 끊어 처리하는 문제
    * 4. 적절한 라이브러리를 찾아서 사용해야하는 문제
    * 5. 2차원 공간 문제
    *
    * (0,0) (0,1) (0,2)
    * (1,0) (1,1) (1,2)
    * (2,0) (2,1) (2,2)
    *
    * [방향벡터 사용]
    * 동 남 서 북
    * dx = {0, 1, 0, -1}
    * dy = {1, 0, -1, 0}
    */

    /**
     * 여행가 A는 N x N 크기의 정사각형 공간 위에 서 있다. 가장 왼쪽 위 좌표는 (1,1)이며 가장 오른쪽 좌표는 (N, N) 이다.
     * 시작 좌표는 (1,1) 이고 L(왼쪽), R(오른쪽), U(위), D(아래)로 이동할 수 있다.
     * N x N 크기의 정사각형 공간을 벗어나는 움직임은 무시한다.
     * 공간의 크기를 나타내는 n과 이동 계획서가 주어질 때 최종 위치를 출력하라
     */

    public void test1(int n, String plans) {

        // 이동 계획서
        String[] plan = plans.split(" ");

        // 방향 백터 셋팅
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Map<String, Integer> map = Map.of("R", 0, "D", 1, "L", 2, "U", 3);

        // 현재 좌표
        int x = 1;
        int y = 1;

        // 임시 이동 좌표
        int moveX = 1;
        int moveY = 1;

        for (int i = 0; i < plan.length; i++) {

            // 임시 이동
            moveX += dx[map.get(plan[i])];
            moveY += dy[map.get(plan[i])];

            // 지도를 넘어가는지 체크 후 처리
            if (moveX >= 1 && moveX <= n)
                x = moveX;
            else
                moveX -= dx[map.get(plan[i])];
            if (moveY >= 1 && moveY <= n)
                y = moveY;
            else
                moveY -= dy[map.get(plan[i])];
        }

        System.out.println(x + " " + y);
    }

}
