package ddwucom.mobile.hw6_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.wifi.aware.PublishConfig;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
        float posX = 100;
        float posY = 100;
        float r = 100;
        int paintColor = Color.CYAN;

    public MyView(Context context) {
            super(context);
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
}

//    // 1.MyView에 onTouchEvent()메소드를 재정의하여 터치한 위치에 원 표시
//    public boolean onTouchEvent(MotionEvent event){
//        if(event.getAction() == MotionEvent.ACTION_DOWN){
//            posX =event.getX();
//            posY =event.getY();
//            Log.d("you","eventX=>"+posX+", eventY=>"+posY);
//            return true;
//
//        }
//        return false;
//    }

    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);

        Paint pnt =new Paint();
        pnt.setColor(paintColor);

        canvas.drawCircle(posX, posY, r, pnt);
        invalidate();
    }

}

