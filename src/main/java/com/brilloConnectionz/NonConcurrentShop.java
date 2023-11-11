package com.brilloConnectionz;

import java.time.LocalDateTime;
import java.util.Random;

public class NonConcurrentShop {
    private static final int MAX_SHOPKEEPER = 12;
    private static final int MAX_USER = 5;
    private static final int NO_USERS = 3;

    public static void main(String[] args) {
        System.out.println("Starting time: " + getCurrentTime());

        Random random = new Random();
        int shopkeeperPancakes = random.nextInt(MAX_SHOPKEEPER + 1);
        int[] userPancakes = new int[NO_USERS];

        int totalUserPancakes = 0;
        for (int i = 0; i < NO_USERS; i++) {
            userPancakes[i] = random.nextInt(MAX_USER + 1);
            totalUserPancakes += userPancakes[i];
        }

        int wastedPancakes = Math.max(0, shopkeeperPancakes - totalUserPancakes);
        boolean metAllNeeds = totalUserPancakes <= shopkeeperPancakes;

        System.out.println("Ending time: " + getCurrentTime());
        System.out.println("Shopkeeper pancakes: " + shopkeeperPancakes);
        System.out.print("User pancakes: ");
        for (int i = 0; i < NO_USERS; i++) {
            System.out.print(userPancakes[i] + " ");
        }
        System.out.println();
        System.out.println("Met all needs: " + metAllNeeds);
        System.out.println("Wasted pancakes: " + wastedPancakes);
        System.out.println("Unmet orders: " + Math.max(0, totalUserPancakes - shopkeeperPancakes));
    }

    private static String getCurrentTime() {
        return LocalDateTime.now().toString();
    }
}
