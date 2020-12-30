package ddwucom.mobile.hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDisplay;
    EditText editText;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnDisplay = findViewById(R.id.btnDisplay);
        tvDisplay = findViewById(R.id.tvDisplay);

////1.별도의 리스너 인터페이스 구현 클래스 작성(2.1방법)
//        MyClick myClick = new MyClick();
//        btnDisplay.setOnClickListener(myClick);//btnDisplay을 onClickListener에 연결

////2. 익명 내부클래스 구현으로 작성
//        btnDisplay.setOnClickListener(myClickListener);

//3. 익명 내부 클래스의 임시 객체 구현방법으로 작성
        btnDisplay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                tvDisplay.setText(text);
            }
        });
    }

    //1.별도의 리스너 인터페이스 구현 클래스 작성(2.1방법)
    class MyClick implements View.OnClickListener{
        @Override
        //onClick Toast 안에 this 쓰면 onClick 에서 인식. MainA.this 로 반드시 써줘야
        public void onClick(View v) {
            String text = editText.getText().toString();
            tvDisplay.setText(text);
        }
    }

    //2. 익명 내부클래스 구현으로 작성
    View.OnClickListener myClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String text = editText.getText().toString();
            tvDisplay.setText(text);
        }
    };
}
