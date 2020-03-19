package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

class PassengerThread extends Thread {

    Semaphore semaphore;
    private int id;
    CountDownLatch CDL;

    PassengerThread(Semaphore sem, int id, CountDownLatch CDL) {
        this.semaphore = sem;
        this.id = id;
        this.CDL = CDL;
    }

    public synchronized void run(){

        try {
            semaphore.acquire();
            System.out.println("К кассе подошел человек с номером: " + id);

            Thread.sleep(500);

            System.out.println("Из кассы вышел человек c номером: " + id);
            semaphore.release();

            CDL.countDown();

            CDL.await();

            if (getId() == 100){
                System.out.println("Автобус полон ");
                System.out.println("Автобус уехал ");
            }

        } catch (Exception E) {
        }
    }

}