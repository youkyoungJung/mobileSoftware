package ddwucom.mobile.hw3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void OnMyBtnClick(View v){

    EditText editText = findViewById(R.id.editText);
    String text = editText.getText().toString();

    switch(v.getId()){
        case R.id.btnOne:
            editText.setText(text + "1");
            break;
        case R.id.btnTwo:
            editText.setText(text + "2");
            break;
        case R.id.btnThree:
            editText.setText(text + "3");
            break;
        case  R.id.btnClear:
            editText.setText("");
            break;
    }
}
}
