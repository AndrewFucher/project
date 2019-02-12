package com.example.mcandrii.project;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {


    private Ships ship;
    private UnLoading unLoading;
    int isFinished = 0;

    public MyThread (Ships ship) {

        this.ship = ship;
        this.unLoading = new UnLoading(500, this.ship);
    }

    @Override
    public Integer call() throws Exception {
        unLoading.process();
        isFinished = 1;
        System.out.println("FIND ME" + this.ship.boxes + 1);
        return 1;
    }
}
