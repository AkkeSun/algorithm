package com.example.algorithm.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Test92334 {

    public static int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> graph = new HashMap<>(); // 신고 내용을 담는 graph
        HashMap<String ,Integer> check = new HashMap<>();         // 아이디별 신고 내용을 담는 hashmap
        HashMap<String, Integer> id_map = new HashMap<>();        // 아이디의 index 값을 젖아하기 위한 hashmap
        boolean [] sendMail = new boolean[id_list.length];        // 메일 발송 유무를 체크하는 boolean

        int[] answer = new int[id_list.length];

        // 초기화
        for (int i =0; i<id_list.length; i++) {
            id_map.put(id_list[i], i);
            graph.put(id_list[i], new HashSet<>());
            check.put(id_list[i], 0);
        }

        // 신고 결과 저장
        for(int i =0 ; i<report.length; i++) {

            String[] s = report[i].split(" ");
            HashSet<String> set = graph.get(s[0]);
            set.add(s[1]);
            graph.put(s[0], set);
            
        }

        
        // 분석
        for(int i = 0 ; i < graph.size(); i++) {
            HashSet<String> set = graph.get(id_list[i]);

            Iterator iter = set.iterator();
            while(iter.hasNext()) {
                String id = (String) iter.next();
                Integer cnt = check.get(id);
                check.put(id, cnt+1);
            }
        }

        // k 이상 신고되었다면 메일 발송유무 true 처리
        for( int i = 0; i < check.size(); i++) {
            int cnt = check.get(id_list[i]);
            if(cnt >= k)
                sendMail[i] = true;
        }

        // id_list 별 신고 아이디가 메일 발송이 되었는지 카운트
        for( int i =0; i< graph.size(); i++ ){
            int cnt = 0;
            HashSet<String> set = graph.get(id_list[i]);

            Iterator iter = set.iterator();
            while(iter.hasNext()) {
                String id = (String) iter.next();
                Integer index = id_map.get(id);
                if(sendMail[index]) {
                    cnt ++;
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] solution = solution(id_list, report, k);

        for(int i =0; i< solution.length; i++) {
            System.out.println(solution[i]);
        }

    }
}
