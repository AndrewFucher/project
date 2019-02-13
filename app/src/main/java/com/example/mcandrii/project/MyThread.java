package com.example.mcandrii.project;

import java.util.concurrent.Callable;

public class MyThread implements Runnable{

    private Ships ship;
    private UnLoading unLoading;

    public MyThread (Ships ship) {

        this.ship = ship;
        this.unLoading = new UnLoading(500, this.ship);
    }

    @Override
    public void run() {
        unLoading.process();
        System.out.println("FIND ME" + this.ship.boxes + 1);
    }
}
