package com.pouzikov.myPackage.InterviewAglorithms;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        int[] array = {2,4,2,4,6,5,6,7,1,7,1};
        singleNumber(array);
    }

    public static void singleNumber(int[] array){
        List<Integer> Answer = new ArrayList<>();

        for(int i : array){
            if(!Answer.contains(i)){
                Answer.add(i);
            }else{
                Answer.remove(Integer.valueOf(i));
            }
        }
        System.out.println(Answer.get(0));
    }
}
