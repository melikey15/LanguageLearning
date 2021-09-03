package com.example.learningapp.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.learningapp.MainActivity;
import com.example.learningapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
TextView name,email;
ImageView userImage;
Button logout;
FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
   name=findViewById(R.id.user_name);
   email=findViewById(R.id.user_email);
   userImage=findViewById(R.id.user_image);
   logout=findViewById(R.id.logout_btn);

user=FirebaseAuth.getInstance().getCurrentUser();


name.setText(user.getDisplayName());
email.setText(user.getEmail());
Glide.with(ProfileActivity.this).load(user.getPhotoUrl()).into(userImage);

logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
  finish();

    }
});

    }
}