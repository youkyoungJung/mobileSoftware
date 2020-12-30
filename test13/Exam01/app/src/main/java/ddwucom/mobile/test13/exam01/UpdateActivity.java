package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText etUpdateId;
    EditText etUpdateFood;

    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etUpdateId = findViewById(R.id.etUpdateId);
        etUpdateFood = findViewById(R.id.etUpdateFood);
        myDbHelper = new FoodDBHelper(this);

    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.btnUpdateFood:

                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etUpdateFood.getText().toString());

                String whereClause = "_id=?";
                String[] whereArgs = new String[] {etUpdateId.getText().toString()};
                myDB.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);
                break;

                case R.id.btnUpdateCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        myDbHelper.close();
        finish();
    }
}
//                ContentValues row2 = new ContentValues();
//                row2.put("nation", "KFC");
//                row2.put("food", "chicken");
//                String whereClause = "food=? and nation=?";
//                String[] whereArgs = new String[] {"한국", "된장찌개"};
//
//                myDB.update(FoodDBHelper.TABLE_NAME, row2, whereClause, whereArgs);