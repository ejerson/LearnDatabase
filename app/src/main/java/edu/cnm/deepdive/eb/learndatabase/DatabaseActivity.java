package edu.cnm.deepdive.eb.learndatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import edu.cnm.deepdive.eb.learndatabase.database.ColorCursorAdapter;
import edu.cnm.deepdive.eb.learndatabase.database.DatabaseHelper;
import edu.cnm.deepdive.eb.learndatabase.fragments.AddContentFragment;

public class DatabaseActivity extends AppCompatActivity {

  public DatabaseHelper dbHelper;
  private ListView databaseListView;
  private SQLiteDatabase sqLiteDatabase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_database);

    databaseListView = (ListView) findViewById(R.id.database_list);


    databaseListView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//        Log.v("clicked", (String)((TextView) view).getText());
      startActivity(new Intent(DatabaseActivity.this, TestActivity.class));
//        Toast toast = Toast.makeText(DatabaseActivity.this, "Item", Toast.LENGTH_SHORT);
//            toast.show();


      }
    });

    dbHelper = new DatabaseHelper(this);

    sqLiteDatabase = dbHelper.getReadableDatabase();

    refresh();

  }

//  public AlertDialog addDeck(View view) {
//    Builder builder = new Builder(this);
//
//    LayoutInflater inflater = this.getLayoutInflater();
//
//    View inflatedView = inflater.inflate(R.layout.dialog_add_content, null);
//    final EditText contentView = inflatedView.findViewById(R.id.new_content);
//    String content = contentView.getText().toString();
//    SQLiteDatabase db = this.dbHelper.getWritableDatabase();
//    this.dbHelper.insert(db, content); // add color to parameter if I want color back
//    this.refresh();
//
//    return builder.create();
//  }


  // query the database
  public void refresh() {
    Cursor cursor = sqLiteDatabase.query(DatabaseHelper.DATABASE_TABLE,
        new String[]{DatabaseHelper.ID_COLUMN, DatabaseHelper.CONTENT_COLUMN, /**DatabaseHelper.COLOR_COLUMN*/},
        null, null, null, null, null);

    ColorCursorAdapter cursorAdapter = new ColorCursorAdapter(this,
        cursor, true);

    databaseListView.setAdapter(cursorAdapter);
  }



  public void showAddDialog(View view) {
    AddContentFragment dialog = new AddContentFragment();
    dialog.show(getSupportFragmentManager(), "AddContentFragment");
  }

  @Override
  protected void onDestroy() {
    dbHelper.close();
    super.onDestroy();
  }
}
