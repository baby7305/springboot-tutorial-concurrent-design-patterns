package com.example.design.activeObject.util;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillchar);

    public abstract void displayString(String string);

    public abstract Result<String> add(String x, String y);

    public abstract Result<String> search(String word);
}

