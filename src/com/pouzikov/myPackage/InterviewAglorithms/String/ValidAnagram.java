package com.pouzikov.myPackage.InterviewAglorithms.String;

public class ValidAnagram {

    public static void main(String[] args) {
        validAnagramPractice("bat","tab");
    }
// When you subtract an A from the charcode, you turn this into arthemitic and it becomes 0. Then from there, it should
// add and subtract the same numbers, all numbers should be zero at each element of the array.
//    https://www.youtube.com/watch?v=6C40mfRiTdA
public static void validAnagramPractice(String word, String t){
    int[] count = new int[26];
    for(int i =0; i< word.length();i++){
        count[word.charAt(i) - 'a']++;
        count[t.charAt(i)-'a']--;
    }

    for(int i : count){
        if(count[i]!=0){
            System.out.println("false");
        }
    }
    System.out.println("true");
}





    public static boolean validAnagram(String word, String t){
            if(word.length()!=t.length()){
        return false;
    }

    int[] count = new int[26];

        for(int i = 0; i <word.length();i++){
        count[word.charAt(i)-'a']++;
        count[t.charAt(i)-'a']--;
    }

        for(int i : count){
        if(i!=0){
            return false;
        }
    }
        return true;
}
}
