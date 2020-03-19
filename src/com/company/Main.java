package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(4, true);
        CountDownLatch CDL = new CountDownLatch(100);
        for (int i = 1; i <= 100; i++) {
            new PassengerThread(sem, i, CDL).start();

        }
    }
}