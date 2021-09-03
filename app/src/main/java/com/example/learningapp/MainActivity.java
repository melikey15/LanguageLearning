package com.example.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.learningapp.authentication.LoginActivity;
import com.example.learningapp.authentication.ProfileActivity;
import com.example.learningapp.leaderboard.LeaderboardActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;

FirebaseUser user;
private BottomNavigationView bottomNavigationView;
private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.my_drawer);
        navigationView=findViewById(R.id.navigation_view);
        toggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);//görünürlük görünmezlik drawer layout için
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//başlıktaki geri düğmesi

navigationView.setNavigationItemSelectedListener(this);// drawer layouttaki toast messagein görünmsi için item seçildiğinde



        bottomNavigationView=findViewById(R.id.bottom_navigation);//bottom menunun görünrülüğü
        navController= Navigation.findNavController(this,R.id.main_fragment);//main fragmente atamak
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//geri çubuğu için
        if(toggle.onOptionsItemSelected(item))
            return true;
        if (item.getItemId()==R.id.profile){
            if (user !=null){
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }else
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.leaderboard:
               startActivity(new Intent(MainActivity.this, LeaderboardActivity.class));
                break;
            case R.id.pdf:
                Toast.makeText(this, "eBook",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rate:
                Toast.makeText(this, "Rate US", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}