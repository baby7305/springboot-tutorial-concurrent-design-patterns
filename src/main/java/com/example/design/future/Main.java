package com.example.design.future;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //定义有返回值的FutureService
        FutureService<String, Integer> service = FutureService.newService();

        //submit方法为立即返回的方法
        Future<?> future = service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello", System.out::println);
    }
}
