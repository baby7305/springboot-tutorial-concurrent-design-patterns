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
        }, "Hello");
        //get方法会使当前线程进入阻塞，最终会返回计算的结果
        System.out.println(future.get());
    }
}
