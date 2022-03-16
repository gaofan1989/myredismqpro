package com.gaofan.mqreids.util;

import java.util.Calendar;

/**
 * 单例模式
 * @author gaofan
 * @create 2021-12-15 21:47
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {

    }
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
