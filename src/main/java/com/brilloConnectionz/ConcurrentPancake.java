package com.brilloConnectionz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConcurrentPancake {
    public static void main(String[] args) {



        for (int i = 0; i < 10; i++) {
            int slot = i + 1;
            System.out.println("Slot: " + slot);
            System.out.println("Starting Time: " + getStartTime(slot) + " seconds");
            System.out.println("Ending Time: " + getEndTime(slot) + " seconds");

            ShopEntity store = new ShopEntity();
            GeneralShopService service = new GeneralShopService();

            CompletableFuture<Integer> pancakesMadeFuture = CompletableFuture.supplyAsync(() -> service.makePancake(store.getMax_pancakes()));
            CompletableFuture<int[]> userOrdersFuture = CompletableFuture.supplyAsync(() -> service.orderMade(new int[store.getMax_customers()], store.getMax_pancake_per_customer()));

            try {
                int pancakesMade = pancakesMadeFuture.get();
                int[] userOrders = userOrdersFuture.get();

                boolean ordersMade = service.metAllOrders(userOrders, pancakesMade);
                int wastedPancakes = service.wastedPancakes(userOrders, pancakesMade);
                int ordersNotMet = service.ordersNotMet(userOrders, pancakesMade);

                System.out.println("Shopkeeper met the needs of all users: " + ordersMade);
                System.out.println("Pancakes wasted: " + wastedPancakes);
                System.out.println("Unmet orders: " + ordersNotMet);
                System.out.println("-------------------------------------");
                System.out.println();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getStartTime(int slot) {
        return (slot - 1) * 30;
    }

    private static int getEndTime(int slot) {
        return slot * 30;
    }
}

