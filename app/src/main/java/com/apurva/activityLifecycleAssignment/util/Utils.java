package com.apurva.activityLifecycleAssignment.util;

import android.os.Handler;
import android.widget.TextView;

import java.util.Map;

public class Utils {
    private static ContextSwitchCounter mCSCounter = ContextSwitchCounter.getInstance();
    private static TimerCounter mTCounter = TimerCounter.getInstance();

    public static void updateActivityAView(final TextView viewTimer, final TextView viewContextSwitch) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
               if(viewTimer != null) {
                    viewTimer.setText(Integer.toString(mTCounter.getCounterValue()));
                }

                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> entry : mCSCounter.getData()) {
                    sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
                }
                if(viewContextSwitch != null) {
                    viewContextSwitch.setText(sb.toString());
                }
            }
        }, 750);
    }
}
