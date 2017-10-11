package com.apurva.activityLifecycleAssignment.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ContextSwitchCounter {
    public static String sOnCreateCountLabel = "OnCreate Count";
    public static String sOnStartCountLabel = "OnStart Count";
    public static String sOnRestartCountLabel = "OnRestart Count";
    public static String sOnResumeCountLabel = "OnResume Count";
    public static String sOnStopCountLabel = "OnStop Count";
    public static String sOnPauseCountLabel = "OnPause Count";
    public static String sOnDestroyCountLabel = "OnDestroy Count";

    private Map<String, Integer> mCountMap;

    private static ContextSwitchCounter sInstance = new ContextSwitchCounter();

    private ContextSwitchCounter() {
        mCountMap = new HashMap<>();
        mCountMap.put(sOnCreateCountLabel, 0);
        mCountMap.put(sOnStartCountLabel, 0);
        mCountMap.put(sOnRestartCountLabel, 0);
        mCountMap.put(sOnResumeCountLabel, 0);
        mCountMap.put(sOnStopCountLabel, 0);
        mCountMap.put(sOnPauseCountLabel, 0);
        mCountMap.put(sOnDestroyCountLabel, 0);
    }

    public static ContextSwitchCounter getInstance() {
        return sInstance;
    }

    public void incrementCount(String key) {
        if(mCountMap.containsKey(key)) {
            Integer val = mCountMap.get(key);
            val++;
            mCountMap.put(key, val);
        } else {
            mCountMap.put(key, 1);
        }
    }

    public Set<Map.Entry<String, Integer>> getData() {
        return mCountMap.entrySet();
    }

    public void clear() {
        mCountMap.clear();
    }

}
