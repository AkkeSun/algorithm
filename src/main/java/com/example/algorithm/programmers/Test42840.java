package com.example.algorithm.programmers;

/**
 * 모의고사 (프로그래머스 42840)
 */
public class Test42840 {
    public static int[] solution(int[] answers) {

        int result [] = new int [3];
        int [] user1 = {1,2,3,4,5};
        int [] user2 = {2,1,2,3,2,4,2,5};
        int [] user3 = {3,3,1,1,2,2,4,4,5,5};

        int user1Cnt = 0;
        int user2Cnt = 0;
        int user3Cnt = 0;
        
        // 점수 계산
        for(int i =0; i<answers.length; i++) {

            int user1Index = i % 5;
            int user2Index = i % 8;
            int user3Index = i % 10;

            if(user1[user1Index] == answers[i])
                user1Cnt ++;
            if(user2[user2Index] == answers[i])
                user2Cnt ++;
            if(user3[user3Index] == answers[i])
                user3Cnt ++;
        }

        // 동점자가 있는지 체크
        if(user1Cnt != 0 && user1Cnt == user2Cnt)
        {
            if(user2Cnt == user3Cnt)
                result = new int[] {1, 2, 3};
            else
                result = new int[] {1, 2};
        }
        else if (user2Cnt != 0 && user2Cnt == user3Cnt)
        {
            if(user3Cnt == user1Cnt)
                result = new int[] {1, 2, 3};
            else
                result = new int[] {2, 3};
        }
        else if (user3Cnt != 0 && user3Cnt == user1Cnt)
        {

            if(user1Cnt == user2Cnt)
                result = new int[] {1, 2, 3};
            else
                result = new int[] {1, 3};
        }
        
        // 동점자가 없다면 최고점자 출력
        else
        {
            if( user1Cnt > user2Cnt && user1Cnt > user3Cnt)
                result = new int[] {1};
            else if( user2Cnt > user1Cnt && user2Cnt > user3Cnt)
                result = new int[] {2};
            else if( user3Cnt > user2Cnt && user3Cnt > user1Cnt)
                result = new int[] {3};
        }

        return result;
    }

    public static void main(String[] args) {

        int[] solution = solution(new int[]{1,2,3,4,5});
        for(int i =0; i<solution.length; i++) {
            System.out.println(solution[i]);
        }

    }


}
