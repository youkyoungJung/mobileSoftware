package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etName;
    EditText etGenre;

    MusicDBManager musicDBManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.add_title);
        etName = findViewById(R.id.add_name);
        etGenre = findViewById(R.id.add_genre);

        musicDBManager = new MusicDBManager(AddActivity.this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_add:

    // 이상에 따른 처리
                if(etTitle.getText().toString().equals("")){
                    Toast.makeText(AddActivity.this, "새로운 음악 추가 실패!", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED);
                }
                else {
                musicDBManager.addNewMusic(new MyMusic(etTitle.getText().toString(),
                        etName.getText().toString(),etGenre.getText().toString()));
                Intent resultIntent = new Intent();
                resultIntent.putExtra("title", etTitle.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
                break;
            case R.id.btn_cancel_update:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
        //musicDBHelper.close();
        finish();
    }
}
