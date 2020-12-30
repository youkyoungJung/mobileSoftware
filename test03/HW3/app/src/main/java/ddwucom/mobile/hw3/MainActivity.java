package ddwucom.mobile.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String msg = "Mobile Software!\n"+
                "Mobile Software!\n"
                + "Mobile Software!\n"
                + "Mobile Software!\n"
                + "Mobile Software!\n"
                + "Mobile Software!\n"
                + "Mobile Software!\n"
                + "Mobile Software!\n";*/
      //  TextView textView = findViewById(R.id.my_test);
      //  textView.setText(msg);
    }

    public void onMyBtnClick(View v){

        EditText myEdit = findViewById(R.id.etName);
        EditText myEdit2 = findViewById(R.id.etPhone);

        String text = myEdit.getText().toString();
        String text2 = myEdit2.getText().toString();

        Toast.makeText(this, "안녕하세요, 저는 "+text+"입니다."+
                "전화번호는 "+text2+" 입니다.", Toast.LENGTH_SHORT).show();

    }

    public void onMyExitClick(View v){
      Button exit = findViewById(R.id.btnExit);
      finish();
    }
}
