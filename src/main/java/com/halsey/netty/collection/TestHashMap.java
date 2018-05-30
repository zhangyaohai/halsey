package com.halsey.netty.collection;

import java.util.HashMap;
import java.util.UUID;

public class TestHashMap {

// -Xmn800m -Xms1000m -Xmx1000m -Xss512k
    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                for ( int i = 0; i <3810; i++) {
                    final int k = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(k+"", "");
                        }
                    }, "ftf" + i).start();

                }

            }

        }, "ftf");

        t.start();
    }
}
