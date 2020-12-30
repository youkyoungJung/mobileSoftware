package ddwucom.mobile.eventtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3. 뷰클래스 생성후 리스너 구현
//        MyView view = new MyView(this);
//        view.setOnTouchListener(view);
//        setContentView(view);
        setContentView(R.layout.activity_main);

        //외부변수 접근
        ConstraintLayout layout = findViewById(R.id.layout);
        final TextView textView = findViewById(R.id.textView);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(MainActivity.this, "Layout TOUCH!", Toast.LENGTH_SHORT).show();
//              event.getX();
//              event.getY();

               if(event.getAction() == MotionEvent.ACTION_DOWN) {
                   textView.setText("Layout TOUCH DOWN!!!");
               }
               else if(event.getAction() == MotionEvent.ACTION_UP) {
                    textView.setText("Layout TOUCH UP!!!");
                }
                return true;
            }
        });



        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        //1.기본 방법 - 클래스 생성 후 작용
        MyClick myClick = new MyClick();
        btn1.setOnClickListener(myClick);//btn1을 onClickListener에 연결
        //2.액티비티 리스너를 구현
        btn2.setOnClickListener(this);
        //4.익명클래스 사용-인터페이스 직접 객체 생성 :제일 일반적
        btn3.setOnClickListener(myClickListener);
        //5.익명 클래스의 임시 객체 사용
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "다섯번째 익명 클래스 임시 객체 방식!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onMyClick(View v){
        Toast.makeText(MainActivity.this, "위젯방식!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "두번째 Activity방식!", Toast.LENGTH_SHORT).show();
    }

    class MyClick implements View.OnClickListener{
        @Override
        //onClick Toast 안에 this 쓰면 onClick 에서 인식. MainA.this 로 반드시 써줘야
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "첫번째 방식!", Toast.LENGTH_SHORT).show();
        }
    }
    View.OnClickListener myClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "네번째 익명 클래스 방식!", Toast.LENGTH_SHORT).show();

        }
    };

//    class MyView extends View implements View.OnTouchListener{
//
//        public MyView(Context context) {
//            super(context);
//        }

//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            canvas.drawColor(Color.YELLOW);
//        }

//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            Toast.makeText(MainActivity.this, "세번째 View 자체 구현 방식!", Toast.LENGTH_SHORT).show();
//
//            return true;//이벤트 처리 완료시 true, 처리를 계속해야할경우 false(상위구현)
//        }
//    }

    //매소드는 선언 했지만 사용하는 부분은 안나타나있음<-운영체제(시스템)에서 호출
    //처리 못할경우 액티비티에서 처리 :method callback
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Toast.makeText(this, "TOUCH EVENT", Toast.LENGTH_SHORT).show();
//        return true;
//    }
}

