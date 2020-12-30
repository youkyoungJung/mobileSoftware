package ddwucom.mobile.hw6_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    private Random random;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);

//2.익명 내부클래스의 임시객체 구현으로 1번과 동일한 기능 작성
        myView.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        myView.posX =event.getX();
                        myView.posY =event.getY();
                        Log.d("you","eventX=>"+myView.posX+", eventY=>"+myView.posY);
                        return false;
                    }
                    return false;
                }
        });

//3.롱클릭할 경우 원의 새강이 바뀌는 기능, 익명 내부클래스의 임시 객체 구현 방법
        myView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                random = new Random();
                int c = (random.nextInt(3));

                if(c == 0)
                    myView.paintColor = Color.BLUE;
                else if(c == 1)
                    myView.paintColor = Color.GREEN;
                else
                    myView.paintColor = Color.RED;

                return false;
            }
        });
    }
}
