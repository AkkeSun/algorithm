package com.example.algorithm.search;


import java.util.Arrays;
import java.util.Scanner;


/**
 * 오름차순 정렬되어있는 수열과 N이 주어질 따
 * 수열에 N이 몇 개 있는지 검색하시오
 * ( 이진 탐색 응용 )
 */
public class SearchExample2 {

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,2,3};
        int result = bSerach(arr, 2);
        System.out.println(result);
    }

    public static int bSerach(int [] arr, int target) {

        int start = 0;
        int end = arr.length -1;

        while(start <= end) {
            if(arr[start] != target) {
                start ++;
            }
            if (arr[end] != target) {
                end --;
            }
            if(arr[start] == arr[end] && arr[end]==target)
                return end - start + 1;
        }

        return -1;
    }

}
