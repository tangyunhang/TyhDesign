package com.tyh.configuration.interf;

public interface tyh01 {
    public void t1();
    default void defaultMethod() {
        System.out.println("Default method in interface 1");
    }
}
