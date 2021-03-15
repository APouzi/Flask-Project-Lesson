package com.pouzikov.myPackage.InterviewAglorithms;
//Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
//
//The operation of drinking a full water bottle turns it into an empty bottle.
//
//Return the maximum number of water bottles you can drink.
public class WaterBottlesBearBottles {
    public static void main(String[] args) {
        System.out.println(bottles(9,3));
    }


    public static int waterBottles(int bottles, int exchange){
    int counter = 1;
    while(counter <= bottles){
        if(counter % exchange ==0){
            bottles++;
        }
        counter++;
    }
    return bottles;
        }



















    public static int bottles(int beerBottles, int exchangeNum){
        int counter= 1;

        while(counter<=beerBottles){
            if(counter%exchangeNum==0) {
                beerBottles++;
            }
                counter++;

        }
        return beerBottles;
    }
}
