package com.example.design.future;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        Content content1 = Retriever.retrieve("http://www.baidu.com/");
        Content content2 = Retriever.retrieve("http://www.tencent.com/");
        Content content3 = Retriever.retrieve("http://www.hyuki.com/");

        saveToFile("baidu.html", content1);
        saveToFile("tencent.html", content2);
        saveToFile("hyuki.html", content3);

        long end = System.currentTimeMillis();

        System.out.println("Elapsed time = " + (end - start) + "msec.");
    }

    // 将content中的内容写入名为filename的文件中
    private static void saveToFile(String filename, Content content) {
        byte[] bytes = content.getBytes();
        try {
            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
            FileOutputStream out = new FileOutputStream(filename);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
