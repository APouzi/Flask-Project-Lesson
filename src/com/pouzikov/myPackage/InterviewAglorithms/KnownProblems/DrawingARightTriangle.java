package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

import java.util.Scanner;

public class DrawingARightTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String character = scanner.next();
        int triangleHeight = scanner.nextInt();
        scanner.close();
        rightTriangle(character,triangleHeight);
    }

    public static void rightTriangle(String character, int triangleHeight){
        int num = 0;
        while(num <= triangleHeight){
            System.out.println();
            for (int i = 0; i <= num; i++) {
                System.out.print(character + " ");
            }

            num++;
        }
    }
}
