package ddwucom.mobile.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        ArrayList<String> foods = (ArrayList<String>) intent.getSerializableExtra("foods");//객체 꺼낼때

        Log.d("you", "id: "+id);
        Log.d("you", "food1: "+ foods.get(0));
        Log.d("you", "food2: "+ foods.get(1));
        Log.d("you", "food3: "+ foods.get(2));

    }
}
