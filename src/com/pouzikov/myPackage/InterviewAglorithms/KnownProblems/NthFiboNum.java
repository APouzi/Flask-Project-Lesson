package com.pouzikov.myPackage.InterviewAglorithms.KnownProblems;

public class NthFiboNum {
    public static void main(String[] args) {
        System.out.println(nthFibo2(5));
        nthFibo(5);
    }



    public static int nthFibo2(int num){
        if( num == 1 || num == 2){
            return 1;
        }

        int a = 0, b = 1, sum = 3;

        while( num > 1){
            sum = a + b;
            a = b;
            b = sum;
            num--;
        }
        return sum;
    }











    private static void nthFibo(int num){
        if(num == 0 || num == 1){
            System.out.println(num);
        }
        int a = 0;
        int b =1;
        int sum = 0;
        while(num>1){
            sum = a +b;
            a = b;
            b = sum;
            num--;
        }
        System.out.println(sum);
    }
}
