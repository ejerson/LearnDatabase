package edu.cnm.deepdive.eb.learndatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

  public static final String DATABASE_NAME = "LIST_CONTENT";
  public static final String DATABASE_TABLE = "LIST_TABLE";

  public static final int DATABASE_VERSION = 1;

  public static final String ID_COLUMN = "_id";
  public static final String CONTENT_COLUMN = "content";
//  public static final String COLOR_COLUMN = "color";

  private static final String SCRIPT_CREATE_DATABASE =
      "CREATE TABLE " + DATABASE_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement, "
          + CONTENT_COLUMN + " text not null)"
      ; //remove this if I want to add the color back
//          + COLOR_COLUMN + " text not null);";

  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME+".db", null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(SCRIPT_CREATE_DATABASE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

  }

  // insert into my sqlite database
  public long insert(SQLiteDatabase db, String content) {  // add String color parameter if I want color back
    ContentValues contentValues = new ContentValues();
    contentValues.put(CONTENT_COLUMN, content);
    return db.insert(DATABASE_TABLE, null, contentValues);
//    contentValues.put(COLOR_COLUMN, color);

  }
}
