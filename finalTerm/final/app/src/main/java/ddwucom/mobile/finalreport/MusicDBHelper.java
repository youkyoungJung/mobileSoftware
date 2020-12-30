package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MusicDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MusicDBHelper";

    final static  String DB_NAME = "music_db";
    public final static  String TABLE_NAME = "music_table";

    public final static  String COL_ID = "_id";
    public final static  String COL_TITLE = "title";
    public final static  String COL_NAME = "name";
    public final static  String COL_GENRE = "genre";
    public final static  String COL_DATE = "date";
    public final static String COL_COMPANY = "company";
    //public final static String COL_IMAGE = "image";

    public MusicDBHelper(Context context){
        super(context, DB_NAME,null, 1);
    }

    int[] images = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4};

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME +  " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_NAME + " TEXT, " + COL_GENRE + " TEXT, "
                + COL_DATE + " TEXT, " + COL_COMPANY + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, 'KILL THIS LOVE', '블랙핑크', '힙합', '2020.02.02', 'YG');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '에잇', '아이유', '가요', '2020.02.09', 'EDAM');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '환상동화', '아이즈원','가요', '2020.04.21', 'SWING');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '깡', '비','발라드', '2020.03.09', 'RAIN');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
