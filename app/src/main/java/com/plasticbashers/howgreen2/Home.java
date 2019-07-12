package com.plasticbashers.howgreen2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.plasticbashers.howgreen2.Firebase.User;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpPage();
    }

    public void setUpPage(){
        TextView textView = findViewById(R.id.username_view);
        final User user = new User();
        textView.setText(user.getEmail());

        Button btn_Login = findViewById(R.id.logout_button);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.signOut();
                startActivity(new Intent(Home.this, Login.class));
            }
        });
    }
}
