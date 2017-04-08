package com.example.yash.whereami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setFlags();
        doubleTouchListener();

    }

    private void doubleTouchListener() {
        OnSwipeTouchListener listener = new OnSwipeTouchListener(SplashActivity.this) {

            @Override
            public void onDoubleClick(){
                super.onDoubleClick();
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                SplashActivity.this.finish();
            }
        };
        View view = findViewById(R.id.activity_splash);
        view.setOnTouchListener(listener);

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.linear_group);
        for(int index=0; index<(viewGroup).getChildCount(); ++index) {
            View nextChild = (viewGroup).getChildAt(index);
            nextChild.setOnTouchListener(listener);
        }
    }

    private void setFlags() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
