package com.apurva.activityLifecycleAssignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.apurva.activityLifecycleAssignment.util.ContextSwitchCounter;
import com.apurva.activityLifecycleAssignment.util.TimerCounter;
import com.apurva.activityLifecycleAssignment.util.Utils;

public class ActivityA extends Activity {
    private String mActivityName;
    private TextView mTimerCounterView;
    private TextView mContextSwitchCounterView;
    private TimerCounter mTimerCounter = TimerCounter.getInstance();
    private ContextSwitchCounter mContextSwitchCounter = ContextSwitchCounter.getInstance();
    private CountDownTimer mTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mActivityName = getString(R.string.activity_a_label);
        mTimerCounterView = (TextView)findViewById(R.id.timer_counter_view);
        mContextSwitchCounterView = (TextView)findViewById(R.id.context_switch_counters_view);

        mTimer = new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        mTimerCounter.incrementCount();
                        Utils.updateActivityAView(mTimerCounterView, mContextSwitchCounterView);
                    }
                    public void onFinish() {
                        mTimer.start(); // restart the timer
                    }
                };
        mTimer.start();

        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnCreateCountLabel);
        Utils.updateActivityAView(mTimerCounterView, mContextSwitchCounterView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnStartCountLabel);
        Utils.updateActivityAView(mTimerCounterView, mContextSwitchCounterView);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnRestartCountLabel);
        Utils.updateActivityAView(mTimerCounterView, mContextSwitchCounterView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnResumeCountLabel);
        Utils.updateActivityAView(mTimerCounterView, mContextSwitchCounterView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnPauseCountLabel);
        Utils.updateActivityAView(mTimerCounterView, mContextSwitchCounterView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnStopCountLabel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimerCounter.reset();
        mContextSwitchCounter.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }

}
