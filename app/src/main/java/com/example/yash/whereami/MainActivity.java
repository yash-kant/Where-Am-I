package com.example.yash.whereami;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;

public class MainActivity extends AppCompatActivity {

    Snackbar bottomSnackbar;
    TSnackbar topSnackbar;
    private int question_id = 0;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContext(this);
        setStatic();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setListeners();
    }

    private void setStatic() {
        setScreenSize();
        setImageParam();


    }

    private void setImageParam() {
        StaticData.imageHeight = 516;
        StaticData.imageWidth = 959;
    }

    private void setListeners() {
        View view = findViewById(R.id.touch_view);
        view.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onDoubleClick(){
               super.onDoubleClick();
               dismissSnackbars();
           }

            @Override
            public void onClick(){
                super.onClick();
                setFlags();
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                makeBottomSnackbar();
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                makeTopSnackbar();
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                question_id = question_id < 11 ? ++question_id : 0;
                dismissSnackbars();
                makeBottomSnackbar();
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                question_id = question_id > 0 ? --question_id : 11;
                dismissSnackbars();
                makeBottomSnackbar();
            }
        });
    }

    private void setFlags() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

    void makeBottomSnackbar(){

        bottomSnackbar = Snackbar.make(this.findViewById(android.R.id.content),StaticData.questionArray[question_id], Snackbar.LENGTH_INDEFINITE);
        View view = bottomSnackbar.getView();
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        bottomSnackbar.show();
    }

    void makeTopSnackbar(){
        topSnackbar = TSnackbar.make(this.findViewById(android.R.id.content), "Hint: " + StaticData.hintsArray[question_id], TSnackbar.LENGTH_INDEFINITE);
        View view = topSnackbar.getView();
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.GREEN);
        topSnackbar.show();

    }

    void dismissSnackbars(){
        if(bottomSnackbar != null)
            bottomSnackbar.dismiss();
        if(topSnackbar != null)
            topSnackbar.dismiss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setFlags();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFlags();
    }

    public static void setContext(Context context) {
        MainActivity.context = context;
    }

    public static Context getContext() {
        return context;
    }

    private void setScreenSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        StaticData.screenHeight = metrics.heightPixels;
        StaticData.screenWidth = metrics.widthPixels;
        Log.i("fuck!", "setScreenSize: " + metrics.heightPixels+ "   "+ metrics.widthPixels);
    }

}


