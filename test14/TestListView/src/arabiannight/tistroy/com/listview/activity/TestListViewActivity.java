package arabiannight.tistroy.com.listview.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import arabiannight.tistroy.com.listview.R;
import arabiannight.tistroy.com.listview.adapter.CustomBaseAdapter;
import arabiannight.tistroy.com.listview.data.InfoClass;

public class TestListViewActivity extends Activity {
	
	private ArrayList<InfoClass> mCareList = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setLayout();
        
        mCareList = new ArrayList<InfoClass>();
        
        for(int i = 0 ; i < 10 ; i++){
			mCareList.add(new InfoClass
					(
					i + "번째" + " ListView 입니다.", 
					getResources().getDrawable(R.drawable.ic_launcher), 
					"" + i
					));
		}
        
        // BaseAdapter 연결
        mListView.setAdapter(new CustomBaseAdapter(this, mCareList));
        
        // ArrayAdapter 연결
//        mListView.setAdapter(new CustomArrayAdapter(this, R.layout.list_row, mCareList));
        
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				
				Toast.makeText(
						getApplicationContext(), 
						"ITEM CLICK = " + position,
						Toast.LENGTH_SHORT
						).show();
			}
		});
    }
    
    private ListView mListView = null;
    
    private void setLayout(){
    	mListView = (ListView) findViewById(R.id.lv_list);
    }
}


