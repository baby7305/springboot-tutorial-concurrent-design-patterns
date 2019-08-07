package com.example.design.threadPool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Main {
    public static void main(String[] args) {
        final ProductionChannel channel = new ProductionChannel(5);
        AtomicInteger productNo = new AtomicInteger();

        IntStream.range(1, 8).forEach(i -> new Thread(() -> {
            while (true) {
                channel.offerProduction(new Production(productNo.getAndIncrement()));
                try {
                    TimeUnit.SECONDS.sleep(current().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start());
    }
}
