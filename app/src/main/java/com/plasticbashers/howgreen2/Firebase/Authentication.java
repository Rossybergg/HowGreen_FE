package com.plasticbashers.howgreen2.Firebase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.plasticbashers.howgreen2.Home;

public class Authentication extends AppCompatActivity {

  private FirebaseAuth firebaseAuth;
  private final Context context;

  public Authentication(Context context) {
    this.context = context;
  }

  public void login(String email, String password) {
    firebaseAuth = FirebaseAuth.getInstance();
    firebaseAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // sign in success
              context.startActivity(new Intent(context, Home.class));
            } else {
              // Sign in fails
              Toast.makeText(context, "Email or password is incorrect", Toast.LENGTH_LONG).show();
            }
          }
        });
  }

  public void signUp(String email, String password) {
    firebaseAuth = FirebaseAuth.getInstance();
    firebaseAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // sign in success
              context.startActivity(new Intent(context, Home.class));
            } else {
              // Sign in fails
              Toast.makeText(context, "Sign up failed", Toast.LENGTH_LONG).show();
            }
          }
        });
  }
}
