package com.pouzikov.myPackage.InterviewAglorithms;
//https://leetcode.com/problems/fibonacci-number/
public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(Fibo(6));
    }

    public static int Fibo(int number){
        if(number == 0 ){
            return 0;
        }
           if( number==1){
            return 1;
        }

        int a = 0;
        int b = 1;
        int sum = a+b;

        while(number >1){
            sum = a +b;
            a =b;
            b = sum;
           number--;
        }
        return sum;
    }

// too big
    public static int Fibo2(int num){

        return Fibo2(num-1) + Fibo2(num-2);
    }
}
