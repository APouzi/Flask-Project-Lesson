package com.pouzikov.myPackage.InterviewAglorithms;

public class countPrimeNumbers {

    public static void main(String[] args) {
        primeVersion2(5,10);
    }
    public static int primeVersion2(int start,int n){
        if(n < 2) {
            return 0;
        }
        int count  = 0;
        boolean[] prime = new boolean[n] ;
        prime[0] = prime[1] = true;
        for(int i = 2 ; i * i < n ; i++){
            if(!prime[i]){
                for(int j = i * i ; j < n ; j += i ){
                    prime[j] = true;
                }
            }
        }

        for(boolean i : prime){
            if(!i)count++;
        }

        return count;
    }
}
