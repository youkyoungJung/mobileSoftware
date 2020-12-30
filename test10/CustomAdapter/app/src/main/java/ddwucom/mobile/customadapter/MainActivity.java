package ddwucom.mobile.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyData> myDataList;
    private ListView listView;
    private  MyAdapter myAdapter;
    private DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataList = new ArrayList<MyData>();
//        dataManager = new DataManager();
//        myAdapter = new MyAdapter(this, R.layout.custom_adaper_view, myDataList);

        myDataList.add(new MyData(1,"홍길동","012345"));
        myDataList.add(new MyData(2,"전우치","123456"));
        myDataList.add(new MyData(3,"일지매","234567"));
        myDataList.add(new MyData(4,"홍길동","012345"));
        myDataList.add(new MyData(5,"전우치","123456"));
        myDataList.add(new MyData(6,"일지매","234567"));
        myDataList.add(new MyData(7,"홍길동","012345"));
        myDataList.add(new MyData(8,"전우치","123456"));
        myDataList.add(new MyData(9,"전우치","123456"));
        myDataList.add(new MyData(10,"일지매","234567"));
        myDataList.add(new MyData(11,"일지매","234567"));
        myDataList.add(new MyData(12,"홍길동","012345"));
        myDataList.add(new MyData(13,"전우치","123456"));
        myDataList.add(new MyData(14,"일지매","234567"));
        myDataList.add(new MyData(15,"홍길동","012345"));
        myDataList.add(new MyData(16,"전우치","123456"));
        myDataList.add(new MyData(17,"일지매","234567"));
        myDataList.add(new MyData(18,"홍길동","012345"));


        listView = findViewById(R.id.customListView);

                myAdapter = new MyAdapter(this, R.layout.custom_adaper_view, myDataList);
                listView.setAdapter(myAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, myDataList.get(position).getName(), Toast.LENGTH_SHORT).show();

            }
        });

//                listView.setOnLongClickListener(new AdapterView.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        dataManager.deleteData(v.getId());
//                        return false;
//                    }
//                });
    }
}
