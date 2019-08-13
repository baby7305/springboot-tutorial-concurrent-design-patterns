package com.example.design.future;

public class Retriever {
    public static Content retrieve(String urlstr) {
        return new SyncContentImpl(urlstr);
    }
}
