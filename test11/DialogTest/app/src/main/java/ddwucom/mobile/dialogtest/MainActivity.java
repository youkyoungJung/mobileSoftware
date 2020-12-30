package ddwucom.mobile.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
//버튼 누르면 다이얼로그 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("대화상자 제목")
                        .setMessage("대화상자 메시지")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "확인버튼을 눌렀습니다.",Toast.LENGTH_SHORT ).show();;
                            }
                        })
                        .setNeutralButton("대기버튼", null)
                        //앱 종료해보기
                        .setNegativeButton("취소버튼", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"앱을 종료합니다.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                        //Back 버튼을 눌러도 대화상자가 안닫히게 만듦
//                        .setCancelable(false)
//                        .show();
                            Dialog dlg = builder.create();
                //대화 상자 외부 클릭시 닫히지 않게 할떄
                            dlg.setCancelable(false);
                            dlg.show();

                break;
        }
        //버튼 누르자 바로 앱종료. 계속 수행되고 있다는 것을 알 수 있음(대기X)-Modal과 차이
//        finish();
    }

}
