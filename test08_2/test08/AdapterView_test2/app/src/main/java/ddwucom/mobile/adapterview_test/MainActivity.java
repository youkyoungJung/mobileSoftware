package ddwucom.mobile.adapterview_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    subjectManager subjectManager;
    ArrayAdapter<String> adapter;
    ListView listView;

    EditText editText;

    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedPos = 0;
        editText = findViewById(R.id.editText);

        //데이터 별도 분리
        subjectManager = new subjectManager();

        ArrayList<String> subjectList = subjectManager.getSubjectList();


//        //원본데이터
//        ArrayList<String> subjectList = new ArrayList<String>();// 동적배열
//        subjectList.add("모바일 소프트웨어");
//        subjectList.add("네트워크");
//        subjectList.add("웹서비스");
//        subjectList.add("운영체제");
//        subjectList.add("웹프로그래밍2");

        //배열형태
//        String[] subjectList = {"모바일소프트웨어", "네트워크",
//        "웹서비스", "웹프로그래밍2"};

//        //array.xml사용
//        String[] subjectList
//                = getResources().getStringArray(R.array.subjectList);

        //미리 만들어져있는 arrayAdapter쓸것
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1
                , subjectList
        );
//        //라디오 버튼, activity_main singleChoice
//        //(checked,multiple_choice)  multipleChoice
//                adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_single_choice
//                , subjectList
//        );

        //ListView 결합. ListView 갖고옴
        listView = findViewById(R.id.listView);
        //listView, adapter결합
        listView.setAdapter(adapter);
//        //listView, OnItemListner 연결
//        listView.setOnItemClickListener(itemClickListener);

        //itemClickListener 바로 연결
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "pos: " + position, Toast.LENGTH_SHORT).show();
                selectedPos = position;
                String subject = subjectManager.getItem(position);
                editText.setText(subject);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                subjectManager.removeData(position);
                adapter.notifyDataSetChanged();//갱신
                return true;
            }
        });
//    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MainActivity.this,
//                    "pos: " + position, Toast.LENGTH_SHORT).show();
//        }
//    };
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                String data = editText.getText().toString();
                subjectManager.addData(data);
                adapter.notifyDataSetChanged();
                break;
            case R.id.button2:
                //원본데이터 수정(위치, 바꿀내용)
                //어뎁터에 알림
                String data2 = editText.getText().toString();
                subjectManager.updateDate(selectedPos, data2);
                adapter.notifyDataSetChanged();
                break;
        }
    }

}