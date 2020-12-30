package ddwucom.mobile.test08.adapterclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    ListView listView;

    EditText editText;

    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedPos = 0;
        editText = findViewById(R.id.etItem);

        subjectManager = new SubjectManager();
        subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //click 시 위치, 위에 쓰기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPos = position;
                String subject = subjectManager.getItem(position);
                editText.setText(subject);
            }
        });
        //롱클릭시 삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                subjectManager.removeData(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });


    }
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.btnInsert:
                subjectManager.addData(editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnUpdate:
                subjectManager.updateData(selectedPos, editText.getText().toString());
                adapter.notifyDataSetChanged();
                break;
        }

    }


}
