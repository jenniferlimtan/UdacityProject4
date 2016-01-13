package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.example.android.jokescreenlib.JokeActivity;

/**
 * Created by JenniferAntonette on 11/1/2016.
 */
public class EndpointsAsyncTaskTest  extends AndroidTestCase implements EndpointsAsyncTaskListener{
    EndpointsAsyncTask asyncTask;
    String joke;
    CountDownLatch latch;

    protected void setUp() throws Exception {
        super.setUp();

        latch = new CountDownLatch(1);
        asyncTask = new EndpointsAsyncTask(this);
    }

    public void testGetJoke() throws InterruptedException {
        asyncTask.execute();
        latch.await(20, TimeUnit.SECONDS);

        assertTrue(joke != null);
    }

    @Override
    public void taskCompleted(String joke) {
        this.joke = joke;
        latch.countDown();
    }
}
