package com.plasticbashers.howgreen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.plasticbashers.howgreen2.Firebase.Authentication;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    private Authentication authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        authentication = new Authentication(this);
        setUpRenders();
    }

    public void setUpRenders(){
        final EditText et_Email_Address = findViewById(R.id.et_Email_Address);
        final EditText et_Password = findViewById(R.id.et_password);
        Button btn_Login = findViewById(R.id.btn_Login);
        Button btn_Signup = findViewById(R.id.btn_Signup);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_Email_Address.getText().toString();
                String password = et_Password.getText().toString();
                authentication.login(email, password);
            }
        });
    }


}
