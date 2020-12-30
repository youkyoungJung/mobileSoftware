package ddwucom.mobile.hw10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyData> myDataList;
    private ListView listView;
    private  MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDataList = new ArrayList<MyData>();

        myDataList.add(new MyData(1,"하월곡동","서울시 성북구","좋음"));
        myDataList.add(new MyData(2,"묵1동","서울시 중랑구", "좋음"));
        myDataList.add(new MyData(3,"묵2동","서울시 중랑구", "나쁨"));
        myDataList.add(new MyData(4,"휘경동","서울시 동대문구", "좋음"));
        myDataList.add(new MyData(5,"망우동","서울시 중랑구", "나쁨"));
        myDataList.add(new MyData(6,"상봉동","서울시 중랑구", "좋음"));
        myDataList.add(new MyData(7,"신내동","서울시 중랑구","미세먼지 많음"));
        myDataList.add(new MyData(8,"상월곡동","서울시 성북구", "좋음"));
        myDataList.add(new MyData(9,"면목동","서울시 중랑구", "나쁨"));

        listView = findViewById(R.id.customListView);

        myAdapter = new MyAdapter(this, R.layout.custom_list_view, myDataList);
        listView.setAdapter(myAdapter);
    }
}
