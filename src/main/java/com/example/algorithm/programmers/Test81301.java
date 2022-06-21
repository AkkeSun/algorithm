package com.example.algorithm.programmers;

/**
 * 숫자 문자열과 영단어 (프로그래머스 81301)
 */
public class Test81301 {

    public static int solution(String s) {

        String convert1 = s.replace("zero", "0");
        String convert2 = convert1.replace("one", "1");
        String convert3 = convert2.replace("two", "2");
        String convert4 = convert3.replace("three", "3");
        String convert5 = convert4.replace("four", "4");
        String convert6 = convert5.replace("five", "5");
        String convert7 = convert6.replace("six", "6");
        String convert8 = convert7.replace("seven", "7");
        String convert9 = convert8.replace("eight", "8");
        String convert10 = convert9.replace("nine", "9");


        return Integer.parseInt(convert10);
    }

    public static void main(String[] args) {
        solution("23four5six7");
    }

}
