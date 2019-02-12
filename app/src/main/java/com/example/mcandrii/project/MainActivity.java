package com.example.mcandrii.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    Ships[] ships = new Ships[3];
    int freeDocs;
    int maxDocs;
    ArrayList<Future<Integer>> docs = new ArrayList<Future<Integer>>();
    ArrayList<ExecutorService> aaa = new ArrayList<ExecutorService>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < ships.length; i++) {
            ships[i] = new Ships(i+1, 10);
        }

        System.out.println("FIND ME " + docs);

        freeDocs = 2;
        maxDocs = 2;

        try {
            runThread();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void runThread() throws Exception{

        for(int i = 0; i < ships.length; i++) {

            if (freeDocs <= 0) {
                System.out.println("FIND ME 13u81923");
                freeDocs += docs.get(i % maxDocs).get();
            }

            System.out.println("FIND ME");

            if (freeDocs > aaa.size()) {
                System.out.println("FIND ME !!!" + i % maxDocs);
                aaa.add(i%maxDocs, Executors.newCachedThreadPool());

                System.out.println("FIND ME !!!" + i % maxDocs);

                docs.add(i%maxDocs, aaa.get(i%maxDocs).submit(new MyThread(ships[i])));

                freeDocs += docs.get(i % maxDocs).get();

                System.out.println("FIND ME !!" + aaa.size());

            } else {
                docs.set(i % maxDocs, aaa.get(i % maxDocs).submit(new MyThread(ships[i])));
            }
            freeDocs--;
            System.out.println("FIND ME meeee");
        }

        /*
        ExecutorService executorService = new Executors.newCachedThreadPool();
        Future<Integer> futureCall = executorService.submit(new MyThread().start());
        freeDocs = futureCall.get();*/
    }
}
