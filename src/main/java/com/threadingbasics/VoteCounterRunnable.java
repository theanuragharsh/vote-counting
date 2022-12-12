package com.threadingbasics;

import org.springframework.stereotype.Component;

@Component
public class VoteCounterRunnable implements Runnable {
    Integer counter = 0;

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " : Initial count : " + getCounter() + " : thread Priority : " + Thread.currentThread().getPriority());
        synchronized (this) {
            setCounter(getCounter() + 1);
            System.out.println(" calculating count .. ");
        }
        System.out.println(Thread.currentThread().getName() + " : Final Count : " + getCounter() + " : thread Priority : " + Thread.currentThread().getPriority());
    }
}
