package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity{

    MyMusic myMusic;
    EditText etTitle;
    EditText etName;
    EditText etGenre;
    EditText etDate;
    EditText etCompany;

    MusicDBManager musicDBManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myMusic = (MyMusic) getIntent().getParcelableExtra("myMusic");

        etTitle = findViewById(R.id.title_update);
        etName = findViewById(R.id.name_update);
        etGenre = findViewById(R.id.genre_update);
        etDate = findViewById(R.id.date_update);
        etCompany = findViewById(R.id.company_update);

        etTitle.setText(myMusic.getTitle());
        etName.setText(myMusic.getName());
        etGenre.setText(myMusic.getGenre());
        etDate.setText(myMusic.getDate());
        etCompany.setText(myMusic.getCompany());

        Log.d("you", "getDate: "+ myMusic.getDate());
        musicDBManager = new MusicDBManager(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_update:

                myMusic.setTitle(etTitle.getText().toString());
                myMusic.setName(etName.getText().toString());
                myMusic.setGenre(etGenre.getText().toString());
                myMusic.setDate(etDate.getText().toString());
                myMusic.setCompany(etCompany.getText().toString());

                if(myMusic.getTitle().toString().equals("")){
                    Toast.makeText(UpdateActivity.this, "업데이트 실패!", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED);
                }
                else if(musicDBManager.modifyMusic(myMusic)){
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("myMusic", myMusic);
                    setResult(RESULT_OK, resultIntent);
                }else{
                    setResult(RESULT_CANCELED);
                }
                break;

            case R.id.btn_cancel_update:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
