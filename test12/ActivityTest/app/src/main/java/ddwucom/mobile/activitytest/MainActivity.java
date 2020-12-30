package ddwucom.mobile.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static int code = 100;
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:012-234-567"));
//                startActivity(intent);
                Intent intent = new Intent(MainActivity.this, SubAcitivity2.class);//명시적 인텐트
//                Intent intent = new Intent(MainActivity.this, SubActivity1.class);

                String id = "cooling";

                intent.putExtra("id", id);

                ArrayList<String> foods = new ArrayList<String>();
                foods.add("사과");
                foods.add("오렌지");
                foods.add("포도");

                intent.putExtra("foods", foods);

                startActivityForResult(intent, code);
    //            startActivity(intent);
            break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (code){
            case code:
                if(resultCode == RESULT_OK){
                        String result = data.getStringExtra("result_data");
                    Log.d(TAG, "result: "+ result);
                }else{
                    Log.d(TAG, "canceled");
                }
                break;
        }
    }
}
