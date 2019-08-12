package com.example.design.future;

public interface FutureService<IN, OUT> {
    //提交不需要返回值的任务，Future.get方法返回的将会是null
    Future<?> submit(Runnable runnable);

    //使用静态方法创建一个FutureService的实现
    static <T, R> FutureService<T, R> newService() {
        return new FutureServiceImpl<>();
    }
}
