package com.tyh.interf;

public interface tyh02 {
    public void t2();
    default void defaultMethod() {
        System.out.println("Default method in interface 1");
    }
}
