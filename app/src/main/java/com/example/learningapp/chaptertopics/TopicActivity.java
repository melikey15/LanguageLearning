package com.example.learningapp.chaptertopics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.learningapp.R;
import com.example.learningapp.chapter.five.america;
import com.example.learningapp.chapter.five.china;
import com.example.learningapp.chapter.five.germany;
import com.example.learningapp.chapter.five.india;
import com.example.learningapp.chapter.five.mexico;
import com.example.learningapp.chapter.four.blue;
import com.example.learningapp.chapter.four.brown;
import com.example.learningapp.chapter.four.pink;
import com.example.learningapp.chapter.four.purple;
import com.example.learningapp.chapter.four.yellow;
import com.example.learningapp.chapter.one.cow;
import com.example.learningapp.chapter.one.goat;
import com.example.learningapp.chapter.one.horse;
import com.example.learningapp.chapter.one.pig;
import com.example.learningapp.chapter.one.turkey;
import com.example.learningapp.chapter.seven.chef;
import com.example.learningapp.chapter.seven.firefighter;
import com.example.learningapp.chapter.seven.painter;
import com.example.learningapp.chapter.seven.pilot;
import com.example.learningapp.chapter.seven.singer;
import com.example.learningapp.chapter.six.alien;
import com.example.learningapp.chapter.six.dragon;
import com.example.learningapp.chapter.six.pirate;
import com.example.learningapp.chapter.six.queen;
import com.example.learningapp.chapter.six.witch;
import com.example.learningapp.chapter.three.drink;
import com.example.learningapp.chapter.three.eat;
import com.example.learningapp.chapter.three.run;
import com.example.learningapp.chapter.three.sleep;
import com.example.learningapp.chapter.three.wash;
import com.example.learningapp.chapter.two.apple;
import com.example.learningapp.chapter.two.banana;
import com.example.learningapp.chapter.two.grapes;
import com.example.learningapp.chapter.two.peach;
import com.example.learningapp.chapter.two.plum;

public class TopicActivity extends AppCompatActivity {
    Toolbar toolbar;
    ExpandableHeightGridView gridView;
    String chapterName;
    String arr[] = null;

  

    ImageView chapterImage;


String turkce[]={"İNEK","KEÇİ","AT","DOMUZ","HİNDİ"};//toast mesaj için alt konu başlıklarının türkçesinin tanımlanması
    String turkce1[]={"MUZ","ELMA","ÜZÜM","ŞEFTALİ","ERİK"};
    String turkce2[]={"UYUMAK","YEMEK ","İÇMEK","KOŞMAK","YIKAMAK"};
    String turkce3[]={"MAVİ","PEMBE","MOR","SARI","KAHVERENGİ"};
String turkce4[]={"ALMANYA","HİNDİSTAN","ÇİN","AMERİKA","MEKSİKA"};
    String turkce5[]={"UZAYLI","EJDERHA","KRALİÇE","CADI","KORSAN"};
    String turkce6[]={"PİLOT","İTFAİYECİ","ŞEF","RESSAM","ŞARKICI"};
    TopicAdapter adapter,adapter1;

    String chapter1[] = {"COW ", "GOAT", "HORSE", "PIG", "TURKEY"};//alt konu başlıklarının ingilizcesinin tanımlanması
    String chapter2[] = {"BANANA", "APPLE", "GRAPES", "PEACH", "PLUM"};
    String chapter3[] = {"SLEEP", "EAT", "DRINK", "RUN", "WASH"};
    String chapter4[] = {"BLUE", "PINK", "PURPLE", "YELLOW", "BROWN"};
    String chapter5[]={"GERMANY","INDIA","CHINA","AMERICA","MEXICO"};
    String chapter6[]={"ALIEN","DRAGON","QUEEN","WITCH","PIRATE"};
    String chapter7[]={"PILOT","FIREFIGHTER","CHEF","PAİNTER","SİNGER"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        toolbar = findViewById(R.id.toolbar);
        gridView = findViewById(R.id.topics_name);

        gridView.setExpanded(true);


        setSupportActionBar(toolbar);//toolbar için tanımlamalar

        if (getSupportActionBar() != null)

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        chapterName = getIntent().getStringExtra("chapterName");
chapterImage=findViewById(R.id.chapter_image); // toolbarda seçilen konun resminin gözükmesi

        compareAndOpen();


    }

    private void compareAndOpen() { //konu başlıklarının resimlerinin eklenmesi

        if (chapterName.equals("konu1")) {

chapterImage.setImageResource(R.drawable.animal);
            arr = chapter1;
            getSupportActionBar().setTitle("ANIMALS");

        }
        else if (chapterName.equals("konu2")) {
            chapterImage.setImageResource(R.drawable.fruit);
            arr = chapter2;
            getSupportActionBar().setTitle("FRUITS");



        }
        else if (chapterName.equals("konu3")) {
            chapterImage.setImageResource(R.drawable.verbs);
            arr = chapter3;
            getSupportActionBar().setTitle("VERBS");
        }
        else if (chapterName.equals("konu4")) {
            chapterImage.setImageResource(R.drawable.color);
            arr = chapter4;
            getSupportActionBar().setTitle("COLORS");
        }
        else if(chapterName.equals("konu5")){
            chapterImage.setImageResource(R.drawable.country);
            arr = chapter5;
            getSupportActionBar().setTitle("COUNTRY AND FLAG");
        }
        else if(chapterName.equals("konu6")){
            chapterImage.setImageResource(R.drawable.mixed);
            arr = chapter6;
            getSupportActionBar().setTitle("MIXED");
        }
        else if(chapterName.equals("konu7")){
            chapterImage.setImageResource(R.drawable.profession);
            arr = chapter7;
            getSupportActionBar().setTitle("JOBS");
        }
        else
            arr = null;

        adapter = new TopicAdapter(arr, TopicActivity.this);


        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


    //Toast.makeText(TopicActivity.this,arr[i] , Toast.LENGTH_SHORT).show(); tıklananın adını toast message olarak verilmesi

openActivity(arr[i]);
                Intent myIntent = null;


                if (chapterName.equals("konu1") && i == 0) { //tıklanan itemlere ses dosyası eklemek ve türkçesinin toast mesajının çıkması

                    Toast.makeText(TopicActivity.this,turkce[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound = MediaPlayer.create(TopicActivity.this, R.raw.cow);
                    sound.start();
                                }
                else if (chapterName.equals("konu1") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound1 = MediaPlayer.create(TopicActivity.this, R.raw.goat);
                    sound1.start();
                } else if (chapterName.equals("konu1") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.horse);
                    sound2.start();
                } else if (chapterName.equals("konu1") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound3 = MediaPlayer.create(TopicActivity.this, R.raw.pig);
                    sound3.start();
                } else if (chapterName.equals("konu1") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound4 = MediaPlayer.create(TopicActivity.this, R.raw.turkey);
                    sound4.start();
                }

                if (chapterName.equals("konu2") && i == 0) {
                    Toast.makeText(TopicActivity.this,turkce1[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound = MediaPlayer.create(TopicActivity.this, R.raw.banana);
                    sound.start();
                }
                else if (chapterName.equals("konu2") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce1[i] , Toast.LENGTH_SHORT).show();
                        final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.apple);
                        sound2.start();
                    }
                else if (chapterName.equals("konu2") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce1[i] , Toast.LENGTH_SHORT).show();
                        final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.grapes);
                        sound2.start();
                    }
                else if (chapterName.equals("konu2") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce1[i] , Toast.LENGTH_SHORT).show();
                        final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.peach);
                        sound2.start();
                    } else if (chapterName.equals("konu2") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce1[i] , Toast.LENGTH_SHORT).show();
                        final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.plum);
                        sound2.start();
                    }


                if (chapterName.equals("konu3") && i == 0) {
                    Toast.makeText(TopicActivity.this,turkce2[i], Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound = MediaPlayer.create(TopicActivity.this, R.raw.sleep);
                    sound.start();
                }
                else if (chapterName.equals("konu3") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce2[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.eat);
                    sound2.start();
                }
                else if (chapterName.equals("konu3") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce2[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.drink);
                    sound2.start();
                }
                else if (chapterName.equals("konu3") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce2[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.run);
                    sound2.start();
                } else if (chapterName.equals("konu3") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce2[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.wash);
                    sound2.start();
                }



                if (chapterName.equals("konu4") && i == 0) {
                    Toast.makeText(TopicActivity.this,turkce3[i], Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound = MediaPlayer.create(TopicActivity.this, R.raw.blue);
                    sound.start();
                }
                else if (chapterName.equals("konu4") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce3[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.pink);
                    sound2.start();
                }
                else if (chapterName.equals("konu4") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce3[i], Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.purple);
                    sound2.start();
                }
                else if (chapterName.equals("konu4") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce3[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.yellow);
                    sound2.start();
                } else if (chapterName.equals("konu4") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce3[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.brown);
                    sound2.start();
                }

                if (chapterName.equals("konu5") && i == 0) {
                    Toast.makeText(TopicActivity.this,turkce4[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound = MediaPlayer.create(TopicActivity.this, R.raw.germany);
                    sound.start();
                }
                else if (chapterName.equals("konu5") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce4[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.india);
                    sound2.start();
                }
                else if (chapterName.equals("konu5") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce4[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.china);
                    sound2.start();
                }
                else if (chapterName.equals("konu5") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce4[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.america);
                    sound2.start();
                } else if (chapterName.equals("konu5") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce4[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.mexico);
                    sound2.start();
                }



                if (chapterName.equals("konu6") && i == 0) {
                    Toast.makeText(TopicActivity.this,turkce5[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound = MediaPlayer.create(TopicActivity.this, R.raw.alien);
                    sound.start();
                }
                else if (chapterName.equals("konu6") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce5[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.dragon);
                    sound2.start();
                }
                else if (chapterName.equals("konu6") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce5[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.queen);
                    sound2.start();
                }
                else if (chapterName.equals("konu6") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce5[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.witch);
                    sound2.start();
                } else if (chapterName.equals("konu6") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce5[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.pirate);
                    sound2.start();
                }
                else if (chapterName.equals("konu7") &&i == 0) {
                    Toast.makeText(TopicActivity.this,turkce6[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.pilot);
                    sound2.start();
                }
                else if (chapterName.equals("konu7") &&i == 1) {
                    Toast.makeText(TopicActivity.this,turkce6[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.firefighter);
                    sound2.start();
                }
                else if (chapterName.equals("konu7") &&i == 2) {
                    Toast.makeText(TopicActivity.this,turkce6[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.chef);
                    sound2.start();
                }
                else if (chapterName.equals("konu7") &&i == 3) {
                    Toast.makeText(TopicActivity.this,turkce6[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.painter);
                    sound2.start();
                }
                else if (chapterName.equals("konu7") &&i == 4) {
                    Toast.makeText(TopicActivity.this,turkce6[i] , Toast.LENGTH_SHORT).show();
                    final MediaPlayer sound2 = MediaPlayer.create(TopicActivity.this, R.raw.singer);
                    sound2.start();
                }

            }



        });
}

    private void openActivity(String s) {
        switch (s){
            case "COW ":
                startActivity(new Intent(TopicActivity.this, cow.class));
                break;
            case "GOAT":
                startActivity(new Intent(TopicActivity.this, goat.class));
                break;
            case "HORSE":
                startActivity(new Intent(TopicActivity.this, horse.class));
                break;
            case "PIG":
                startActivity(new Intent(TopicActivity.this, pig.class));
                break;
            case "TURKEY":
                startActivity(new Intent(TopicActivity.this, turkey.class));
                break;
            case "BANANA":
                startActivity(new Intent(TopicActivity.this, banana.class));
                break;
            case "APPLE":
                startActivity(new Intent(TopicActivity.this, apple.class));
                break;
            case "GRAPES":
                startActivity(new Intent(TopicActivity.this, grapes.class));
                break;
            case "PEACH":
                startActivity(new Intent(TopicActivity.this, peach.class));
                break;
            case "PLUM":
                startActivity(new Intent(TopicActivity.this, plum.class));
                break;
            case "SLEEP":
                startActivity(new Intent(TopicActivity.this, sleep.class));
                break;
            case "EAT":
                startActivity(new Intent(TopicActivity.this, eat.class));
                break;
            case "DRINK":
                startActivity(new Intent(TopicActivity.this, drink.class));
                break;
            case "RUN":
                startActivity(new Intent(TopicActivity.this, run.class));
                break;
            case "WASH":
                startActivity(new Intent(TopicActivity.this, wash.class));
                break;
            case "BLUE":
                startActivity(new Intent(TopicActivity.this, blue.class));
                break;
            case "PINK":
                startActivity(new Intent(TopicActivity.this, pink.class));
                break;
            case "PURPLE":
                startActivity(new Intent(TopicActivity.this, purple.class));
                break;
            case "YELLOW":
                startActivity(new Intent(TopicActivity.this, yellow.class));
                break;
            case "BROWN":
                startActivity(new Intent(TopicActivity.this, brown.class));
                break;
            case "GERMANY":
                startActivity(new Intent(TopicActivity.this, germany.class));
                break;
            case "INDIA":
                startActivity(new Intent(TopicActivity.this, india.class));
                break;
            case "CHINA":
                startActivity(new Intent(TopicActivity.this, china.class));
                break;
            case "AMERICA":
                startActivity(new Intent(TopicActivity.this, america.class));
                break;
            case "MEXICO":
                startActivity(new Intent(TopicActivity.this, mexico.class));
                break;
            case "ALIEN":
                startActivity(new Intent(TopicActivity.this, alien.class));
                break;
            case "DRAGON":
                startActivity(new Intent(TopicActivity.this, dragon.class));
                break;
            case "QUEEN":
                startActivity(new Intent(TopicActivity.this, queen.class));
                break;
            case "WITCH":
                startActivity(new Intent(TopicActivity.this, witch.class));
                break;
            case "PIRATE":
                startActivity(new Intent(TopicActivity.this, pirate.class));
                break;
            case "PILOT":
                startActivity(new Intent(TopicActivity.this, pilot.class));
                break;
            case "FIREFIGHTER":
                startActivity(new Intent(TopicActivity.this, firefighter.class));
                break;
            case "CHEF":
                startActivity(new Intent(TopicActivity.this, chef.class));
                break;
            case "PAİNTER":
                startActivity(new Intent(TopicActivity.this, painter.class));
                break;
            case "SİNGER":
                startActivity(new Intent(TopicActivity.this, singer.class));
                break;
        }
    }

}




