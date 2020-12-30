package ddwucom.mobile.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

   //     LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //    LayoutInflater inflater = LayoutInflater.from(this);

      //  LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_main,null);
        LinearLayout layout = (LinearLayout) View.inflate(this,R.layout.activity_main, null);
        setContentView(layout);
       // setContentView(R.layout.activity_main);
    }
}
