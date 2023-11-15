package com.brilloConnectionz;

import java.time.LocalDateTime;
import java.util.Random;

public class NonConcurrentShop {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            int slot = i + 1;
            System.out.println("Slot: " + slot);
            System.out.println("Starting Time: " + getStartTime(slot) + " seconds");
            System.out.println("Ending Time: " + getEndTime(slot) + " seconds");

            ShopEntity store = new ShopEntity();

            GeneralShopService service = new GeneralShopService();


            int pancakes_made = service.makePancake(store.getMax_pancakes());

            int[] user_orders = new int[store.getMax_customers()];

            user_orders = service.orderMade(user_orders, store.getMax_pancake_per_customer());

            boolean ordersMade = service.metAllOrders(user_orders, pancakes_made);

            int wastedPancakes = service.wastedPancakes(user_orders, pancakes_made);

            int ordersNotMet = service.ordersNotMet(user_orders, pancakes_made);
            System.out.println("Shopkeeper met the needs of all users: " + ordersMade);
            System.out.println("Pancakes wasted: " + wastedPancakes);
            System.out.println("Unmet orders: " + ordersNotMet);
            System.out.println("-------------------------------------");
            System.out.println();
        }
    }

    private static int getStartTime(int slot) {
        return (slot - 1) * 30;
    }

    private static int getEndTime(int slot) {
        return slot * 30;
    }
}
