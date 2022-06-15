package com.example.algorithm.search;

/**
 * 이진탐색
 * 원하는 값을 배열 순서대로 찾는게 아니라
 * 배열 중간에 있는 임의의 값을 선택하여 좌측, 우측 따로 검색하는 방법
 * 조건 : 정렬
 */
public class SearchBasic {


    public static void main(String[] args) {

        int [] arr = { 17, 28, 43, 67, 88, 92, 100 };
        System.out.println(binarySearch(arr, 88));

    }


    public static int binarySearch(int [] arr, int target) {

        int start = 0;
        int end = arr.length -1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2 ;
            if ( arr[mid] == target )
                return mid;
            else if (arr[mid] > target)
                end = mid -1;
            else
                start = mid + 1;
        }
        return -1;

    }

}
