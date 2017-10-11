package com.apurva.activityLifecycleAssignment.util;

public class TimerCounter {
    private int mCount;
    // Singleton
    private static TimerCounter sInstance = new TimerCounter();

    public static TimerCounter getInstance() { return sInstance; }

    // Singleton -> private constructor
    private TimerCounter() {
        mCount = 0;
    }

    public void incrementCount() {
        mCount++;
    }
    public int getCounterValue() { return mCount; }
    public void reset() { mCount = 0; }

}
