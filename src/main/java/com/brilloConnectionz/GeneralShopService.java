package com.brilloConnectionz;

import java.util.Random;

public class GeneralShopService {
    private static final Random random = new Random();


    public int makePancake(int max_pancakes){
        int pancakes = random.nextInt(max_pancakes+1);
        System.out.println("Pancakes made: "+ pancakes);
        return pancakes;
    }
    public int[] orderMade(int [] num_orders, int max_pancakes_per_user){
        for(int i = 0; i < num_orders.length; i++){
            num_orders[i] = random.nextInt(max_pancakes_per_user+1);
            System.out.println("User "+(1+i)+" orders: "+ num_orders[i] +" pancakes");
        }
        return num_orders;
    }
    public boolean metAllOrders(int [] num_orders, int max_pancakes){
        int totalOrderMade = 0;
        for (int numOrder : num_orders) {
            totalOrderMade += numOrder;
        }
        System.out.println("Total orders made: "+ totalOrderMade+" pancakes");
        return totalOrderMade <= max_pancakes;
    }
    public int wastedPancakes(int [] num_orders, int max_pancakes){
        int totalOrderMade = 0;
        for (int numOrder : num_orders) {
            totalOrderMade += numOrder;
        }

        if(totalOrderMade < max_pancakes){
            return max_pancakes - totalOrderMade;
        }
        return 0;
    }
    public int ordersNotMet(int [] user_orders, int max_pancakes){
        int ordersMade = 0;
        int ordersNotMet = 0;
        for (int userOrder: user_orders) {
            ordersMade += userOrder;
            if(ordersMade > max_pancakes){
                ordersNotMet += (ordersMade - max_pancakes);
            }
        }
        return ordersNotMet;
    }
}
