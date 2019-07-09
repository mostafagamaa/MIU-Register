package com.example.johnhani.miuapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedpref;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button signin=findViewById(R.id.login);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                DataBase db = new DataBase(getApplicationContext());
                int res[]=new int[4];
                res=db.login(String.valueOf(username.getText()),String.valueOf(password.getText()));
                if(res[1]==1) {
                    sendNotification(view);
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("us_id", res[0]);
                    editor.putString("username", String.valueOf(username.getText()));
                    editor.apply();
                    if(res[2]==1){//we check the role of the user if 1 then open admin page else open student page
                        Intent myIntent = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(myIntent);
                    }
                    else{
                       Intent myIntent = new Intent(getApplicationContext(), StudentActivity.class);
                        startActivity(myIntent);
                    }


                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong username or password!", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                }
            }
        });
    }
    public void sendNotification(View view) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);

        //Create the intent thatâ€™ll fire when the user taps the notification//

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.androidauthority.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);

        mBuilder.setSmallIcon(R.drawable.notification_icon);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("You have Signed in in this application");

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());
    }
}

