package com.pouzikov.myPackage.SortingAlgorithms.Recursion;

public class Recursion {
    public static void main(String[] args) {

        System.out.println(iterativeFactorial(3));
        System.out.println(recursiveFactorial(3));
    }

    // 1! = 1 * 0! = 1
    // 2! = 2 * 1 = 2 * 1!
    // 3! = 3 * 2 * 1 = 3 * 2!
    // 4! = 4 * 3 * 2 * 1 = 4 * 3!

    // n! = n *(n - 1)!


    public static int recursiveFactorial(int num) {

        if (num == 0) {
            return 1;
        }
//3 * 2(because 3-1) * 1(because 2-1) * 1(because the zero above returns 0).
        return num * recursiveFactorial(num - 1);

    }

    public static int iterativeFactorial(int num) {
//We know that if the result is zero, we just return one.
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
//[1*1]*[1*2]*[1*3]
        }

        return factorial;

    }
}
