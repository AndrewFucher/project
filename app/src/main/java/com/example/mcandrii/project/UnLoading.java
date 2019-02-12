package com.example.mcandrii.project;

public class UnLoading {

    Ships ship;
    int timeWait;

    public UnLoading(int timeWait, Ships ship) {
        this.timeWait = timeWait;
        this.ship = ship;
    }


    void process() {
        try {
            Thread.sleep(this.timeWait * this.ship.boxes);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("FIND ME" + this.ship.number);
        this.ship.boxes = 0;
        System.out.println("FIND ME" + this.ship.boxes);
    }
}
