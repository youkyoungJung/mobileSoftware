package ddwucom.mobile.finalreport;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    SearchView searchView;
    MusicDBManager musicDBManager;
    ListView searchListView;
    private ArrayList<MyMusic> myMusicList;
    private MyAdapter myAdapter;
    String etText;
    TextView text;

    int[] images = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4
            , R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView = findViewById(R.id.search);
        searchListView = findViewById(R.id.searchList);

        myMusicList = new ArrayList<MyMusic>();
        myAdapter = new MyAdapter(this, R.layout.activity_list, myMusicList);
        searchListView.setAdapter(myAdapter);

        musicDBManager = new MusicDBManager(SearchActivity.this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                etText = query;
                Log.d("you", "검색결과 저장 : "+ etText);
                myMusicList.clear();
                myMusicList.addAll(musicDBManager.getMusicByTitle(etText));
                myAdapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        myMusicList.clear();
        myMusicList.addAll(musicDBManager.getMusicByTitle(etText));
        myAdapter.notifyDataSetChanged();
    }
}