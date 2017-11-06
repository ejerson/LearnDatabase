package edu.cnm.deepdive.eb.learndatabase.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import edu.cnm.deepdive.eb.learndatabase.R;

public class ColorCursorAdapter extends CursorAdapter {

  public ColorCursorAdapter(Context context, Cursor c, boolean autoRequery) {
    super(context, c, autoRequery);
  }

  @Override
  public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
    return LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
  }

  @Override
  public void bindView(View view, Context context, Cursor cursor) {
    String content = cursor.getString(1);
//    String color = cursor.getString(2);

    TextView textView = (TextView) view;
    textView.setText(content);
//    textView.setBackgroundColor(Color.parseColor(color));
  }
}
