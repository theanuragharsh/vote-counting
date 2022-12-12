package com.threadingbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoteCountingApplication {

    public static void main(String[] args) {

        SpringApplication.run(VoteCountingApplication.class, args);
        VoteCounterRunnable voteCounterRunnable = new VoteCounterRunnable();
        Thread thread1 = new Thread(voteCounterRunnable);
        thread1.setPriority(10);  // MAX_PRIORITY (value=10) This thread will execute first
        thread1.setName("state_1");  //using Thread methods to set name of thread
        Thread thread2 = new Thread(voteCounterRunnable);
        thread2.setPriority(1);   // MIN_PRIORITY (value=1)  This thread will execute last
        thread2.setName("state_2");
        Thread thread3 = new Thread(voteCounterRunnable, "state_3"); //we can provide thread-name directly while creating thread as second argument
        Thread thread4 = new Thread(voteCounterRunnable, "state_4");
        Thread thread5 = new Thread(voteCounterRunnable, "state_5");
        thread5.setPriority(5);   // NORM_PRIORITY (value=5)

//        starting threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

}
