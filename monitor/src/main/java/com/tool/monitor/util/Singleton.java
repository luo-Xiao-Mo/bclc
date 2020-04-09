package com.tool.monitor.util;

public class Singleton {
    private volatile static RestUtil instance = null;

    // 私有化构造方法
    private Singleton() {

    }

    public static RestUtil getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new RestUtil();
                }
            }

        }
        return instance;
    }
}
