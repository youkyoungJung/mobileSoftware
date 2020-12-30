package ddwucom.mobile.test11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    foodManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new foodManager();

        listView = findViewById(R.id.listView);

        // DataManager 적용해 볼 것
        foodList = manager.foodList;

        foodList = manager.getFoodList();

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String food = foodList.get(position).getFood();
                final int index = position; //포지션은 돌고 종료하기 떄문에 미리 상수로 설정해 줘야함

                //다이얼로그 기능 구현
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        //position 확인후 원본데이터 보기
                        .setMessage(food + "(을)를 삭제하시겠습니까? ")
                        //setMessage 대신 setItems 사용
//                        .setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                Toast.makeText(MainActivity.this, "선택: "+foods[which],Toast.LENGTH_SHORT).show();
//                            }
//                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //원본데이터 삭제 후 화면에 반영
                                //원본데이터 메니저클래스가 담당. 요청해야함. 위치 포지션 이용
                                manager.deleteFood(index);

                                //어뎁터 다시 연결해줘야함 - 원본데이터 변경됬으므로
                                adapter.notifyDataSetChanged();
                            }
                        })

                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    public void onClick(View v){
        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.order_layout, null);

        switch (v.getId()){
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(" 음식 추가 ")
                        .setView(orderLayout)
                        .setPositiveButton("추가 ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            //다이얼로그 레이아웃에 있는 et를 가져와서 문자열을 읽어옴

                                EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                                EditText etQuantity = orderLayout.findViewById(R.id.etQuantity);

                                String name = etProduct.getText() + " ";
                                String  country = etQuantity.getText() + " ";

                                manager.addFood(new Food(name, country));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소 ", null)
                        .show();
                break;
        }
    }
}
