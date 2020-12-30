//과제명: 음악 플레이리스트 만들기
//분반 : 02분반
//학번: 20181013 성명: 정유경
//제출일: 7월 1일
//검색기능 -  위젯사용, 이미지 사용

package ddwucom.mobile.finalreport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static int ADD_CODE = 100;
    final static int UPDATE_CODE = 200;

    private ArrayList<MyMusic> myMusicList;
    private ListView listView;
    private MyAdapter myAdapter;
    private MusicDBManager musicDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        myMusicList = new ArrayList<MyMusic>();
        musicDBManager = new MusicDBManager(this);
        myAdapter = new MyAdapter(this, R.layout.activity_list, myMusicList);
        listView.setAdapter(myAdapter);

        //클릭: 수정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyMusic myMusic = myMusicList.get(position);
                Intent intent3 = new Intent(MainActivity.this, UpdateActivity.class);
                intent3.putExtra("myMusic", myMusic);
                startActivityForResult(intent3, UPDATE_CODE);
            }
        });

        //길게 눌러 삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("재생목록 삭제")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(musicDBManager.removeMusic(myMusicList.get(pos).get_id())){
                                    Toast.makeText(MainActivity.this, "삭제완료했습니다.", Toast.LENGTH_SHORT).show();
                                    myMusicList.clear();
                                    myMusicList.addAll(musicDBManager.getMusic());
                                    myAdapter.notifyDataSetChanged();
                                }else{
                                    Toast.makeText(MainActivity.this,"삭제실패",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        myMusicList.clear();
        myMusicList.addAll(musicDBManager.getMusic());
        myAdapter.notifyDataSetChanged();
    }
    //메뉴 형성메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.add:
                Toast.makeText(this,"음악을 추가합니다",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,ADD_CODE);
                break;
            case R.id.info:
                Toast.makeText(this, "개발자를 소개합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, InfoActivity.class);
                startActivity(intent2);
                break;
            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("앱 종료");
                builder.setMessage("앱을 종료하시겠습니까?");
                builder.setNegativeButton("취소버튼", null);
                builder.setPositiveButton("종료버튼", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                break;
            case R.id.search:
                Intent intent4 = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent4);
                break;

        }
        return true;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_CODE) {  // AddActivity 호출 후 결과 확인
            switch(resultCode) {
                case RESULT_OK:
                    String title = data.getStringExtra("title");
                    Toast.makeText(this, title + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "노래 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
     }else if(requestCode == UPDATE_CODE){
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "노래 수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "노래 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
