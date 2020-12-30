package ddwucom.mobile.test11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;


    int selectedIndex = 0;
    boolean[] selectedItems = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // DataManager 적용해 볼 것


        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
//        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);
//
//        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가

    }
    public void onClick(View v) {

        final String[] foodArray = {"라면", "김밥", "떡볶이", "오뎅"};

        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.custom_layout, null);

        switch (v.getId()) {
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("대화상자 제목")
//                        .setItems(foodArray, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
////                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this, "선택: " + foodArray[which], Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                selectedIndex = which;
//                            }
//                        })// 라디오 박스
//                        .setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                selectedItems[which] = isChecked; //선택항목 유지
//                            }
//                        })

                        .setIcon(R.mipmap.ic_launcher)
                        .setView(orderLayout)

                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                String result = "";
//
//                                for(int i=0; i < selectedItems.length; i++){
//                                    if(selectedItems[i])
//                                        result += foods[i] + " ";
//                                }

                                EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                                EditText etQuantity = orderLayout.findViewById(R.id.etQuantity);
                                CheckBox cdPayment = orderLayout.findViewById(R.id.cdPayment);

                                String result = etProduct.getText() + " : " + etQuantity.getText() + " "+ cdPayment.isChecked();

                                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                break;
        }

    }

}
