package ddwucom.mobile.hw4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

   // private static final String TAG = ;
    LinearLayout layout;
    int num = 0;
    int num2 = 0;
    int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayout);

    }

    public void onClick (View v){

        EditText editText = findViewById(R.id.etDisplay);
        String text = editText.getText().toString();

        switch(v.getId()){
            case R.id.btn_1:
                editText.setText(text+"1");
                break;
            case R.id.btn_2:
                editText.setText(text+"2");
                break;
            case R.id.btn_plus:
                num = Integer.parseInt(text);
                editText.setText("");
                text = "";
                break;
            case R.id.btn_equal:
                num2 = Integer.parseInt(text);
                answer = (num + num2);
                editText.setText(""+answer);
                break;

        }
    }
}
