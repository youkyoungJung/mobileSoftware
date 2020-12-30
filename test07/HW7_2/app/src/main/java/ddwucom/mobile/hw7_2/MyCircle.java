package ddwucom.mobile.hw7_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {

    float circleR = 80;
    float circleX = 600;
    float circleY = 700;
    int paintColor = Color.RED;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getCircleR(){
        return circleR;
    }
    public void setCircleR(float circleR){
        this.circleR = circleR;
    }
    public void setPaintColor(int paintColor){this.paintColor = paintColor; }
    public int getPaintColor(){return paintColor;}

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);

        Paint pnt = new Paint();
        pnt.setColor(paintColor);

       canvas.drawCircle(circleX,circleY,circleR,pnt);
       invalidate();
    }
}
