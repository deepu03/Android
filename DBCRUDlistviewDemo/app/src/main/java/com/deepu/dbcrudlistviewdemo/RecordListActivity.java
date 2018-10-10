package com.deepu.dbcrudlistviewdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecordListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Model> mList;
    RecordListAdapter madapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Record List");

        listView = findViewById(R.id.listView);
        mList = new ArrayList<>();
        madapter = new RecordListAdapter(this, R.layout.row, mList);
        listView.setAdapter(madapter);

        Cursor cursor = MainActivity.mSQLiteHelper.getData("SELECT * FROM RECORD");
        mList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);

            mList.add(new Model(id, username, email, password));
        }
        madapter.notifyDataSetChanged();
        if (mList.size() == 0) {
            Toast.makeText(this, "No Record Found....", Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(RecordListActivity.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (i == 0) {
                            Cursor c = MainActivity.mSQLiteHelper.getData("SELECT id FROM RECORD");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()) {
                                arrID.add(c.getInt(0));

                            }
                            showDialogUpdate(RecordListActivity.this, arrID.get(position));
                        }
                        if (i == 1) {

                            Cursor c = MainActivity.mSQLiteHelper.getData("SELECT id FROM RECORD");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()) {
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    private void showDialogDelete(final int idRecord) {
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(RecordListActivity.this);
        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Are you sure to delete?");
        dialogDelete.setCancelable(false);

        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    MainActivity.mSQLiteHelper.deleteData(idRecord);
                    Toast.makeText(RecordListActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
                updateRecordList();
            }
        });
        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void showDialogUpdate(Activity activity, final int position) {
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.update_dialog);
        dialog.setTitle("Update");

        final EditText eName = dialog.findViewById(R.id.editname);
        final EditText eEmail = dialog.findViewById(R.id.editemail);
        final EditText ePwd = dialog.findViewById(R.id.editpwd);

        Button btnUpdate = dialog.findViewById(R.id.update);

        Cursor cursor = MainActivity.mSQLiteHelper.getData("SELECT * FROM RECORD WHERE id="+position);
        mList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            eName.setText(username);
            String email = cursor.getString(2);
            eEmail.setText(email);
            String password = cursor.getString(3);
            ePwd.setText(password);

            mList.add(new Model(id, username, email, password));
        }

        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MainActivity.mSQLiteHelper.updateData(
                            eName.getText().toString().trim(),
                            eEmail.getText().toString().trim(),
                            ePwd.getText().toString().trim(), position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception error) {
                    Log.e("Update Error", error.getMessage());
                }
                updateRecordList();
            }
        });
    }

    private void updateRecordList() {
        Cursor cursor = MainActivity.mSQLiteHelper.getData("SELECT * FROM RECORD");
        mList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);

            mList.add(new Model(id, username, email, password));
        }
        madapter.notifyDataSetChanged();
    }

}
