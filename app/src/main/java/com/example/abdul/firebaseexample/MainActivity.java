package com.example.abdul.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {
EditText tokenText;
Button getToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("blog").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
            }
        });//this code above subscribes to the topic blog
        setContentView(R.layout.activity_main);

        tokenText = (EditText)findViewById(R.id.tokenText);
        getToken = (Button)findViewById(R.id.getTokenButton);

        getToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tokenText.setText(FirebaseInstanceId.getInstance().getToken());


            }
        });//this code above handles token registration
    }
}
