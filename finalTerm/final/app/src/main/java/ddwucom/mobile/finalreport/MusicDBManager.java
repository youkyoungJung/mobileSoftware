package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MusicDBManager {
    MusicDBHelper musicDBHelper = null;
    Cursor cursor = null;

    public MusicDBManager(Context context){musicDBHelper = new MusicDBHelper(context);}

    //myMusic 저장
    public ArrayList<MyMusic> getMusic(){
        ArrayList musicList = new ArrayList();
        SQLiteDatabase db = musicDBHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " +  MusicDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()){
            long _id = cursor.getLong(cursor.getColumnIndex(MusicDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_TITLE));
            String name = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_NAME));
            String genre = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_GENRE));
            String date = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_DATE));
            String company = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_COMPANY));
            musicList.add(new MyMusic(_id, title, name, genre, date, company));
        }
        cursor.close();
        musicDBHelper.close();
        return musicList;
    }


    //DB에 새로운 음악 추가
    public boolean addNewMusic(MyMusic newMusic){
        SQLiteDatabase db = musicDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(MusicDBHelper.COL_TITLE, newMusic.getTitle());
        value.put(MusicDBHelper.COL_NAME, newMusic.getName());
        value.put(MusicDBHelper.COL_GENRE, newMusic.getGenre());

        long count = db.insert(MusicDBHelper.TABLE_NAME, null, value);
        musicDBHelper.close();
        if(count > 0) return true;
        return false;
    }
    //DB음악 수정하기
    public  boolean modifyMusic(MyMusic myMusic){
        SQLiteDatabase sqLiteDatabase = musicDBHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(MusicDBHelper.COL_TITLE, myMusic.getTitle());
        row.put(MusicDBHelper.COL_NAME, myMusic.getName());
        row.put(MusicDBHelper.COL_GENRE, myMusic.getGenre());
        row.put(MusicDBHelper.COL_DATE, myMusic.getDate());
        row.put(MusicDBHelper.COL_COMPANY, myMusic.getCompany());

        String whereClause = MusicDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(myMusic.get_id()) };

        int result = sqLiteDatabase.update(musicDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        musicDBHelper.close();
        if(result > 0) return true;
        return false;
    }
    //DB에서 음악 삭제
    public boolean removeMusic(long id) {
        SQLiteDatabase sqLiteDatabase = musicDBHelper.getWritableDatabase();
        String whereClause = musicDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(id)};
        int result = sqLiteDatabase.delete(musicDBHelper.TABLE_NAME, whereClause, whereArgs);
        musicDBHelper.close();
        if (result > 0) return true;
        return false;
    }
    //제목으로 노래 검색
    public ArrayList<MyMusic> getMusicByTitle(String title) {
        ArrayList musicList = new ArrayList();
        SQLiteDatabase db = musicDBHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "
                + MusicDBHelper.TABLE_NAME + " WHERE title = ? ", new String[]{String.valueOf(title)});

        while(cursor.moveToNext()){
            long _id = cursor.getLong(cursor.getColumnIndex(MusicDBHelper.COL_ID));
            String sel_title = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_TITLE));
            String name = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_NAME));
            String genre = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_GENRE));
            String date = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_DATE));
            String company = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_COMPANY));
            musicList.add(new MyMusic(_id, sel_title, name, genre, date, company));
        }
        cursor.close();
        musicDBHelper.close();
        return musicList;

    }
}
