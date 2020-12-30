package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);
        myDbHelper = new FoodDBHelper(this);

    }
    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.btnAddFood:

                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());
                row.put(FoodDBHelper.COL_NATION, etNation.getText().toString());

                myDB.insert (FoodDBHelper.TABLE_NAME, null, row);
                break;

            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }

}
