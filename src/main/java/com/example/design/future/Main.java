package com.example.design.future;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //定义不需要返回值的FutureService
        FutureService<Void, Void> service = FutureService.newService();

        //submit方法为立即返回的方法
        Future<?> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am finish done");
        });
        //get方法会使当前线程进入阻塞
        future.get();
    }
}
