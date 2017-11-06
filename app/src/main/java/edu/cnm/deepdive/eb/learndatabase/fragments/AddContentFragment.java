package edu.cnm.deepdive.eb.learndatabase.fragments;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import edu.cnm.deepdive.eb.learndatabase.DatabaseActivity;
import edu.cnm.deepdive.eb.learndatabase.R;

public class AddContentFragment extends DialogFragment {

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Builder builder = new Builder(getActivity());

    LayoutInflater inflater = getActivity().getLayoutInflater();

    View inflatedView = inflater.inflate(R.layout.dialog_add_content, null);

    // declare them final to be able to access these inside my OnClickListener
    // this value will never change, it makes this variable immutable
    // this variable can't refer to another textView
    final EditText contentView = inflatedView.findViewById(R.id.new_content);
//    final EditText colorView = inflatedView.findViewById(R.id.new_color);

    builder.setView(inflatedView)

       .setPositiveButton(R.string.ok, new OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) {
           SQLiteDatabase db = ((DatabaseActivity)getActivity()).dbHelper.getWritableDatabase();

           String content = contentView.getText().toString();
//           String color = colorView.getText().toString();

//           try {
//             // post to database if color is valid
//             Color.parseColor(color);
//             // add to database
             ((DatabaseActivity)getActivity()).dbHelper.insert(db, content); // add color to parameter if I want color back
//
             ((DatabaseActivity)getActivity()).refresh();
//           } catch (IllegalArgumentException e) {
//             Toast toast = Toast.makeText(getContext(), "Invalid Color, Try Again", Toast.LENGTH_SHORT);
//                 toast.show();
//           }
         }
       })
        .setNegativeButton(R.string.cancel, new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
                AddContentFragment.this.getDialog().cancel();
          }
        });
    return builder.create();
  }
}
