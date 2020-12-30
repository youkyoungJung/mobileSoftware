package ddwucom.mobile.hw5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyView myView;
    private Random random;
    int x =100;
    int y =100;
    int r =80;
    int width;
    int height;

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        myView = findViewById(R.id.myView);
        width = myView.getWidth();
        height = myView.getHeight();
        Log.d("you","width=>"+width+",height=>"+height);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("you","width=>"+width+",height=>"+height);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.myView);
    }

    public void onClick(View v){

        Log.d("you","x=>"+x+", y=>"+y+", z=>"+r);
        random  = new Random();
        x = random.nextInt(width);
        y = random.nextInt(height);
        r = (random.nextInt(3)+1)*100;
        Log.d("you","x=>"+x+", y=>"+y+", z=>"+r);

        switch (v.getId()){
            case R.id.button:
                myView.setCircleX(x);//랜덤지정값 만들기.
                myView.setCircleY(y);
                myView.setCircleR(r);
                myView.invalidate();
                break;
        }

    }
}
