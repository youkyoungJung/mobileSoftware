package ddwucom.mobile.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubAcitivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_acitivity2);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonOK:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", "goood~");
                setResult(RESULT_OK, resultIntent);

                break;
            case R.id.buttonC:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
