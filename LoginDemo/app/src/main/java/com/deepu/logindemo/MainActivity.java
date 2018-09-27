package com.deepu.logindemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);

    }

    public void onLoginButtonClick(View view)
    {
        String username=e1.getText().toString();
        String password=e2.getText().toString();

        if(username.equals("Deepali") && password.equals("deepu@123"))
        {
            Intent intent=new Intent(this,welcome.class);

            intent.putExtra("un",username);
            startActivity(intent);


        }

        else{
            Toast.makeText(this, "Incorrect Username or Password ", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onBackPressed()
    {
        createAlertDialogBox();
    }

    public void createAlertDialogBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EXIT?");
        builder.setMessage("Do you want to exit");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


    builder.setNegativeButton("No", new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialogInterface, int i)
        {
            dialogInterface.dismiss();
        }
    });

    AlertDialog ad=builder.create();
        ad.show();
}
}












