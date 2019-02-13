package com.example.mcandrii.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    Ships[] ships = new Ships[3];
    private int maxDocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < ships.length; i++) {
            ships[i] = new Ships(i+1, 10);
        }

        System.out.println("FIND ME " + this.maxDocs);

        this.maxDocs = 2;

        try {
            runThread();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void runThread(){

        ExecutorService executorService = Executors.newFixedThreadPool(this.maxDocs);

        for(int i = 0; i < ships.length; i++) {
            executorService.execute(new MyThread(ships[i]));
        }
        executorService.shutdown();

        /*
        ExecutorService executorService = new Executors.newCachedThreadPool();
        Future<Integer> futureCall = executorService.submit(new MyThread().start());
        freeDocs = futureCall.get();*/
    }
}
