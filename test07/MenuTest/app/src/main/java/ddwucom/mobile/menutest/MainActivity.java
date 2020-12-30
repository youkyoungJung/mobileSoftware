package ddwucom.mobile.menutest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG="MainActivity";//TAG는 final 상수로

    final static int MENU_FIRST = 100;
    final static int MENU_SECOND = 200;

    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Context Menu 사용 View를 Activity에 등록
        TextView textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

//        popup = new PopupMenu(this,textView);
//
//        popup.getMenuInflater().inflate(R.menu.menu_main,popup.getMenu());
//
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(MainActivity.this,"Hi!",
//                        Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

//        //팝업메뉴뜨게 작업
//        textView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popup.show();
//                return false;
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.group_menu,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.textView:
//                //롱클릭, 텍스트를 만들기 위한 메뉴를 만들면됨
                menu.setHeaderTitle("Context Menu");
                menu.add(0,MENU_FIRST,0,"FIRST");
                menu.add(0,MENU_SECOND,0,"SECOND");

                //메뉴추가되는것(이전꺼 없애려면 clear시켜야함),xml사용한것
                getMenuInflater().inflate(R.menu.menu_content,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MENU_FIRST:
                Log.i(TAG,"context01");
                break;
            case MENU_SECOND:
                Log.i(TAG,"context02");
                break;
            case R.id.third:
                Log.i(TAG,"context03");
                break;
            case R.id.forth:
                Log.i(TAG,"context04");
                break;
        }

        return super.onContextItemSelected(item);
    }

    //    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if(true) {
//            menu.clear();
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//        }
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.gitem01:
                //체크를 확인하는 문장
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                break;
            case R.id.gitem02:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                break;
            case R.id.gitem03:
                item.setChecked(true);
                break;
            case R.id.gitem04:
                item.setChecked(true);//자동으로 라디오박스는 체크되면 다른하나 삭제
                break;
        }

        return true;
    }
//    //얘가 우선 (onOptionsItemSelected얘보다 우선)
//    public void onMenuItemClick(MenuItem item){
//
//        Log.i(TAG, "item01 is clicked!!!!");
//    }

}
