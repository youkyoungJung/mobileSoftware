package ddwucom.mobile.customview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//            MyView vw = new MyView(this);
//
//            setContentView(vw);// 임플레이션 하지 않고 바로 보여줌
    }

    static class MyView extends View {


        public MyView(Context context) {
            super(context);
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

//            canvas.drawColor(Color.LTGRAY);
//
//            Paint pnt = new Paint();
//            pnt.setColor(Color.BLUE);
//            canvas.drawCircle(100,100,80,pnt);
        }
    }

    public void onClick(View canvas){

        MyCustomView myView = findViewById(R.id.MyView);
        myView.setCircleY(myView.getCircleY()+ 100);
//        myView.setY(200);
        myView.invalidate();
    }
}

