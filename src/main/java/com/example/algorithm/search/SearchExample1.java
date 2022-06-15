package com.example.algorithm.search;


import java.util.Arrays;
import java.util.Scanner;




/**
 * 떡볶이 떡 만들기
 * 높이가 19, 14, 10, 17인 떡이 나란히 있고 절단기 높이를 15cm로 가정한다면
 * 자른뒤 떡의 높이는 15, 14, 10, 15가 되고 잘린 떡 길이의 총합은 6이 된다.
 *
 * 손님이 M 만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하여라
 *
 * 입력 :
 * 4, 6 -> 떡의 갯수와 떡의 길이
 * 19, 15, 10, 17
 *
 * 출력 :
 * 15
 *
 */
public class SearchExample1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = Integer.parseInt(sc.next());
        int order = Integer.parseInt(sc.next());

        int [] arr = new int[cnt];
        for(int i = 0 ; i < cnt; i ++) {
            arr[i] = Integer.parseInt(sc.next());
        }

        Arrays.sort(arr);
        
        // 떡 최대길이-1 ~ 떡 최소길이 +1 조사
        for(int knife = arr[cnt-1]-1; knife > arr[0];  knife--) {

            int dduck = 0;

            // 떡 자르기
            for(int j = 0; j < cnt; j++) {
                
                // 떡이 칼 길이보다 긴 경우만 자르기
                if(knife < arr[j]) {
                    dduck += arr[j] - knife;
                }
            }

            // 맞는지 체크
            if(dduck == order) {
                System.out.println("knife : " + knife);
                break;
            }
        }
    }

}
