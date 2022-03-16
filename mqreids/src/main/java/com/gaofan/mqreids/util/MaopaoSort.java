package com.gaofan.mqreids.util;

import java.util.Random;

/**
 * @author gaofan
 * @create 2021-12-15 21:55
 */
public class MaopaoSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = random.nextInt(100);
        }
        for (int i : ints) {
            System.out.println(i);
        }
        System.out.println("--------------------------");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < (ints.length - i - 1); j++) {
                int temp = ints[j + 1];
                if (temp < ints[j]) {
                    ints[j +1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
