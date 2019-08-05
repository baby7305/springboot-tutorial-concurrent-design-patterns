package com.example.design.gui;

import com.example.design.gui.thread.GracefulThread;
import com.example.design.gui.thread.ServiceThread;

public class Service {
    private static GracefulThread thread = null;

    // 服务开始运行（如果服务在运行中则balk）
    public synchronized static void service() {
        System.out.print("service");
        if (thread != null && thread.isAlive()) {
            // Balking
            System.out.println(" is balked.");
            return;
        }
        // Thread-Per-Message
        thread = new ServiceThread();
        thread.start();
    }

    // 服务中止
    public synchronized static void cancel() {
        if (thread != null) {
            System.out.println("cancel.");
            thread.shutdownRequest();
        }
    }
}