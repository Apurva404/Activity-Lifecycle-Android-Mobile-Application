package com.apurva.activityLifecycleAssignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.apurva.activityLifecycleAssignment.util.ContextSwitchCounter;

public class ActivityB extends Activity {
    private String mActivityName;
    private ContextSwitchCounter mContextSwitchCounter = ContextSwitchCounter.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mActivityName = getString(R.string.activity_b_label);
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnCreateCountLabel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnStartCountLabel);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnRestartCountLabel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnResumeCountLabel);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnPauseCountLabel);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnStopCountLabel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContextSwitchCounter.incrementCount(ContextSwitchCounter.sOnDestroyCountLabel);
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityB.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
    }

    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }
}
