package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }


    public void onClick(View v) {
//        버튼의 종류에 따라 결과 설정 후 finish()
//추가, 취소버튼 눌렀을때 따라 setResult 사용.
        switch (v.getId()) {
            case R.id.btn_add:
            Intent intent = new Intent();
//        intent.putExtra("FOOD: ", "EDITtext로 받은 음식이름");
//        intent.putExtra("nation: ", "EDITtext로 받은 나라이름"); ->이거 대신에 food tkdyd

            Food newfood = new Food(etFood.getText().toString(), etNation.getText().toString());
            intent.putExtra("food", newfood);
            setResult(RESULT_OK, intent);
            break;
        }
        finish();
    }
}

