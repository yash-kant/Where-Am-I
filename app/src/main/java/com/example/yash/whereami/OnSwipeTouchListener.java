package com.example.yash.whereami;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class OnSwipeTouchListener implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context c) {
        gestureDetector = new GestureDetector(c, new GestureListener());
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        Log.i("TAG", "onTouch: " + StaticData.screenHeight + "   " + StaticData.screenWidth);
        detectTouches(motionEvent);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private void detectTouches(final MotionEvent motionEvent) {

        //Get the static data and the touch coordinates and implement the required listener

        double sw = StaticData.screenWidth;
        double sh = StaticData.screenHeight;
        double x = motionEvent.getX();
        double y = motionEvent.getY();

        Log.i("Touch", x + "   " + y);

        switch (StaticData.questionId){
            case 0:questionOneListener(sw,sh,x,y);break;
            case 1:questionTwoListener(sw,sh,x,y);break;
            case 2:questionThreeListener(sw,sh,x,y);break;
            case 3:questionFourListener(sw,sh,x,y);break;
            case 4:questionFiveListener(sw,sh,x,y);break;
            case 5:questionSixListener(sw,sh,x,y);break;
            case 6:questionSevenListener(sw,sh,x,y);break;
            case 7:questionEightListener(sw,sh,x,y);break;
            case 8:questionNineListener(sw,sh,x,y);break;
            case 9:questionTenListener(sw,sh,x,y);break;
            case 10:questionElevenListener(sw,sh,x,y);break;
            case 11:questionTwelveListener(sw,sh,x,y);break;
        }

    }

    private void questionTwelveListener(double sw, double sh, double x, double y) {

        double cx = 1227.0/1920;
        double cy = 49.0/1080;
        double rw = 53.78187278415017/1920;

        double ax = cx*sw;
        double ay = cy*sh;
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's the kite.", Toast.LENGTH_SHORT).show();


    }

    private void questionElevenListener(double sw, double sh, double x, double y) {

        //clockwise

        double cx = 244.0/1920;
        double cy = 352.0/1080;
        double rw = 34.245872784150166/1920;

        double ax = cx*sw;//1260
        double ay = cy*sh;// 592
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's flower 1.", Toast.LENGTH_SHORT).show();

        cx = 447.0/1920;
        cy = 656.0/1080;
        rw = 34.245872784150166/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's flower 2.", Toast.LENGTH_SHORT).show();

        cx = 50.0/1920;
        cy = 371.0/1080;
        rw = 53.78187278415017/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's flower 3 & 4.", Toast.LENGTH_SHORT).show();


    }

    private void questionTenListener(double sw, double sh, double x, double y) {

        double cx1 = 128.0/1920;
        double cy1 = 369.0/1080;

        double cx2 = 49.0/1920;
        double cy2 = 167.0/1080;

        double cx3 = 296.0/1920;
        double cy3 = 193.0/1080;

        double ax1 = cx1*sw;
        double ay1 = cy1*sh;

        double ax2 = cx2*sw;
        double ay2 = cy2*sh;

        double ax3 = cx3*sw;
        double ay3 = cy3*sh;

        if(isInTheTraingle(x,y,ax1,ax2,ax3,ay1,ay2,ay3))
            Toast.makeText(MainActivity.getContext(),"There's caterpillar. ", Toast.LENGTH_SHORT).show();

    }

    private void questionNineListener(double sw, double sh, double x, double y) {
        //going clockwise

        double cx = 1585.0/1920;
        double cy = 82.0/1080;
        double rw = 37.797872784150165/1920;

        double ax = cx*sw;//1260
        double ay = cy*sh;// 592
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's ant 1.", Toast.LENGTH_SHORT).show();

        cx = 1832.0/1920;
        cy = 198.0/1080;
        rw = 43.12587278415016/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's ant 2.", Toast.LENGTH_SHORT).show();

        cx = 1851.0/1920;
        cy = 989.0/1080;
        rw = 67.98987278415017/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's ant 3.", Toast.LENGTH_SHORT).show();

        cx = 397.0/1920;
        cy = 727.0/1080;
        rw = 41.34987278415017/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's ant 4.", Toast.LENGTH_SHORT).show();

        cx = 84.0/1920;
        cy = 958.0/1080;
        rw = 66.21387278415017/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's ant  5.", Toast.LENGTH_SHORT).show();
    }

    private void questionEightListener(double sw, double sh, double x, double y) {
        double cx = 1364.0/1920;
        double cy = 780.0/1080;
        double rw = 67.98987278415017/1920;

        double ax = cx*sw;//1260
        double ay = cy*sh;// 592
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's the book.", Toast.LENGTH_SHORT).show();
    }

    private void questionSevenListener(double sw, double sh, double x, double y) {

        double cx1 = 1060.0/1920;
        double cy1 = 159.0/1080;

        double cx2 = 1036.0/1920;
        double cy2 = 41.0/1080;

        double cx3 = 1160.0/1920;
        double cy3 = 30.0/1080;

        double ax1 = cx1*sw;
        double ay1 = cy1*sh;

        double ax2 = cx2*sw;
        double ay2 = cy2*sh;

        double ax3 = cx3*sw;
        double ay3 = cy3*sh;

        if(isInTheTraingle(x,y,ax1,ax2,ax3,ay1,ay2,ay3))
            Toast.makeText(MainActivity.getContext(),"There's the monkey hiding. ", Toast.LENGTH_SHORT).show();


    }

    private void questionSixListener(double sw, double sh, double x, double y) {

        double cx = 1163.0/1920;
        double cy = 768.0/1080;
        double rw = 37.797872784150165/1920;

        double ax = cx*sw;
        double ay = cy*sh;
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's slipper 1.", Toast.LENGTH_SHORT).show();

        cx = 1631.0/1920;
        cy = 723.0/1080;
        rw = 37.797872784150165/1920;

        ax = cx*sw;
        ay = cy*sh;
        ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's slipper 2.", Toast.LENGTH_SHORT).show();




    }

    private void questionFiveListener(double sw, double sh, double x, double y) {

        //bottom owl
        double cx1 = 531.0/1920;
        double cy1 = 261.0/1080;

        double cx2 = 424.0/1920;
        double cy2 = 378.0/1080;

        double cx3 = 727.0/1920;
        double cy3 = 281.0/1080;

        double ax1 = cx1*sw;
        double ay1 = cy1*sh;

        double ax2 = cx2*sw;
        double ay2 = cy2*sh;

        double ax3 = cx3*sw;
        double ay3 = cy3*sh;



        if(isInTheTraingle(x,y,ax1,ax2,ax3,ay1,ay2,ay3))
            Toast.makeText(MainActivity.getContext(),"That's owl 1.", Toast.LENGTH_SHORT).show();

        //top owl

         cx1 = 393.0/1920;
         cy1 = 223.0/1080;

         cx2 = 565.0/1920;
         cy2 = 113.0/1080;

         cx3 = 417.0/1920;
         cy3 = 80.0/1080;

         ax1 = cx1*sw;
         ay1 = cy1*sh;

         ax2 = cx2*sw;
         ay2 = cy2*sh;

         ax3 = cx3*sw;
         ay3 = cy3*sh;



        if(isInTheTraingle(x,y,ax1,ax2,ax3,ay1,ay2,ay3))
            Toast.makeText(MainActivity.getContext(),"That's owl 2.", Toast.LENGTH_SHORT).show();


    }

    private void questionFourListener(double sw, double sh, double x, double y) {

        //cat near the girl
        double cx = 1260.0/1920;
        double cy = 592.0/1080;
        double rw = 48.45387278415017/1920;

        double ax = cx*sw;//1260
        double ay = cy*sh;// 592
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar))
            Toast.makeText(MainActivity.getContext(), "That's kitty 1.", Toast.LENGTH_SHORT).show();

        //cat in the bush

        double cx1 = 1590.0/1920;
        double cy1 = 733.0/1080;

        double cx2 = 1646.0/1920;
        double cy2 = 891.0/1080;

        double cx3 = 1728.0/1920;
        double cy3 = 722.0/1080;

        double ax1 = cx1*sw;//625
        double ay1 = cy1*sh;//1046

        double ax2 = cx2*sw;//1009.0
        double ay2 = cy2*sh;//911

        double ax3 = cx3*sw;//947
        double ay3 = cy3*sh;//1048



        if(isInTheTraingle(x,y,ax1,ax2,ax3,ay1,ay2,ay3))
            Toast.makeText(MainActivity.getContext(),"Correct you've found kitty 2", Toast.LENGTH_SHORT).show();



    }

    private void questionThreeListener(double sw, double sh, double x, double y) {

        //made a change here to 1920
        double cx = 1635.0/1920;
        double cy = 453.0/1080;
        double rw = 48.45387278415017/1920;

        double ax = cx*sw;//1635
        double ay = cy*sh;// 453
        double ar = rw*sw;


        if(isInTheSquare(x,y,ax,ay,ar))
        Toast.makeText(MainActivity.getContext(), "There goes the Sun.", Toast.LENGTH_SHORT).show();

    }

    private void questionTwoListener(double sw, double sh, double x, double y) {

        double cx1 = 615.0/1920;
        double cy1 = 0.9953703703703703;

        double cx2 = 1019.0/1920;
        double cy2 = 0.7694444444444445;

        double cx3 = 942.0/1920;
        double cy3 = 0.9953703703703703;

        double ax1 = cx1*sw;//625
        double ay1 = cy1*sh;//1046

        double ax2 = cx2*sw;//1009.0
        double ay2 = cy2*sh;//911

        double ax3 = cx3*sw;//942
        double ay3 = cy3*sh;//1048


        Log.i("Triangle", ax1 + "   " + ay1 +"   " + ax2 + "   " + ay2 +"   " + ax3 + "   " + ay3 +"   ");


        if(isInTheTraingle(x,y,ax1,ax2,ax3,ay1,ay2,ay3))
            Toast.makeText(MainActivity.getContext(),"Correct you've found the butterfly wing!", Toast.LENGTH_SHORT).show();


    }

    private void questionOneListener(double sw, double sh, double x, double y) {

        double cx = 723.0/1920;
        double cy = 0.1434108527131783;
        double rw = 55.55787278415016/1920;

        double ax = cx*sw;
        double ay = cy*sh;
        double ar = rw*sw;

        if(isInTheSquare(x,y,ax,ay,ar)){
            Toast.makeText(MainActivity.getContext(),"Correct you've found The Earth!", Toast.LENGTH_SHORT).show();
//                Log.i("Earth", ax + "   " + ay +"   " + ar + "   "+ x + "   "+ y);
        }
        //        Log.i("TAG", ax + "   " + ay +"   " + ar + "   "+ x + "   "+ y);
    }

    private boolean isInTheTraingle(double x,double y,double x1,double x2,double x3,double y1,double y2, double y3 ){

        //Calculate with the areas.

        double ABC = Math.abs (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        double ABP = Math.abs (x1 * (y2 - y) + x2 * (y - y1) + x * (y1 - y2));
        double APC = Math.abs (x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
        double PBC = Math.abs (x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));

        double sum = (ABP + APC + PBC);

        Log.i("Triangle function ", "isInTheTraingle: " + (int)sum + "  " + (int)ABC);
        return (int)sum == (int)ABC;

    }

    private boolean isInTheSquare(double x, double y, double ax, double ay, double ar) {

        if(x<=ax+ar && x >= ax-ar)
            if(y<= ay+ar && y >= ay-ar)
            {
                Log.i("Square", "isInTheSquare ");
                return true;
            }

        return false;
    }






    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onClick();
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            onDoubleClick();
            return super.onDoubleTap(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            onLongClick();
            super.onLongPress(e);
        }

        // Determines the fling velocity and then fires the appropriate swipe event accordingly
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeDown();
                        } else {
                            onSwipeUp();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {

    }

    public void onSwipeLeft() {

    }

    public void onSwipeUp() {

    }

    public void onSwipeDown() {

    }

    public void onClick() {


    }

    public void onDoubleClick() {

    }

    public void onLongClick() {
    }
}
