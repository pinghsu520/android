package com.benjdd.prime;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PrimeRunnable implements Runnable {

    long numberToCheck = 0;
    AppCompatActivity invokerActivity = null;
    boolean isPrime = false;


    public PrimeRunnable(AppCompatActivity activity, long number) {
    }

    @Override
    public void run() {
    }
}
