package com.example.yash.whereami;

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

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Snackbar bottomSnackbar;
    TSnackbar topSnackbar;
    private static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContext(this);
        setStatic();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setListeners();
        makeBottomSnackbar();
    }

    //Set Static Data
    private void setStatic() {
        setScreenSize();
        StaticData.questionId = 0;
        Arrays.fill(StaticData.booleenArray,false);
    }

    //Add gesture and click listeners to the view
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
                StaticData.questionId = StaticData.questionId < 11 ? ++StaticData.questionId : 0;
                dismissSnackbars();
                makeBottomSnackbar();
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                StaticData.questionId = StaticData.questionId > 0 ? --StaticData.questionId : 11;
                dismissSnackbars();
                makeBottomSnackbar();
            }
        });
    }

    //set up the orientation and make nav bar and status bar invisible
    private void setFlags() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

    //displays question
    void makeBottomSnackbar(){

        bottomSnackbar = Snackbar.make(this.findViewById(android.R.id.content),StaticData.questionArray[StaticData.questionId], Snackbar.LENGTH_INDEFINITE);
        View view = bottomSnackbar.getView();
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        bottomSnackbar.show();
    }

    //displays hint
    void makeTopSnackbar(){
        topSnackbar = TSnackbar.make(this.findViewById(android.R.id.content), "Hint: " + StaticData.hintsArray[StaticData.questionId], TSnackbar.LENGTH_INDEFINITE);
        View view = topSnackbar.getView();
        TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.GREEN);
        topSnackbar.show();

    }

    //dismisses both question and hint
    void dismissSnackbars(){
        if(bottomSnackbar != null)
            bottomSnackbar.dismiss();
        if(topSnackbar != null)
            topSnackbar.dismiss();
    }

    public static void setContext(Context context) {
        MainActivity.context = context;
    }

    public static Context getContext() {
        return context;
    }

    private void setScreenSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        StaticData.screenHeight = metrics.heightPixels;

        switch (StaticData.screenHeight){

            //standard forms
            case 1440: StaticData.screenWidth = 2560;break;
            case 1080: StaticData.screenWidth = 1920;break;
            case 540:StaticData.screenWidth = 960;break;

            default: StaticData.screenWidth = metrics.widthPixels;
        }
        Log.i("Resolution", "setScreenSize: "+ metrics.widthPixels+ "   "+ metrics.heightPixels);
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

}


