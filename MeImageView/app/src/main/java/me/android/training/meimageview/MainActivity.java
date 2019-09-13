package me.android.training.meimageview;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private ImageView imvCharacter;
    private Button btnChange;
    private String[] characters = {"doremon", "pokemon", "songoku"};
    private String[] backgrounds = {"one", "two", "three", "four"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        randomBackground();

    }

    private void randomBackground(){
        Random random   = new Random();
        int position    = random.nextInt(backgrounds.length);
        int id  = getResources().getIdentifier("background_" + backgrounds[position], "drawable", getPackageName());
        linearLayout.setBackgroundResource(id);
    }


    private void init(){
        imvCharacter    = (ImageView) findViewById(R.id.imvCharacter);
        btnChange       = (Button) findViewById(R.id.btnChange);
        linearLayout    = (LinearLayout) findViewById(R.id.myLinear);
        imvCharacter.setImageResource(R.drawable.songoku);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 0  1 2
                // characters[1] = pokemon
                Random random   = new Random();
                int position    = random.nextInt(characters.length);
                int id  = getResources().getIdentifier(characters[position], "drawable", getPackageName());
                imvCharacter.setImageResource(id);
            }
        });
    }
}
