package me.android.training.randomnumber;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CheckBox ckbBackground;
    private CheckBox ckbTextColor;
    private CheckBox ckbTextCenter;
    private RadioGroup rdgNumberType;
    private RadioButton rdbOdd;
    private RadioButton rdbEven;
    private RadioButton rdbBoth;
    private Button btnShow;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        ckbBackground   = (CheckBox) findViewById(R.id.ckbBackground);
        ckbTextColor    = (CheckBox) findViewById(R.id.ckbTextColor);
        ckbTextCenter   = (CheckBox) findViewById(R.id.ckbTextCenter);
        rdgNumberType   = (RadioGroup) findViewById(R.id.rdgNumberType);
        rdbOdd          = (RadioButton) findViewById(R.id.rdbOdd);
        rdbEven         = (RadioButton) findViewById(R.id.rdbEven);
        rdbBoth         = (RadioButton) findViewById(R.id.rdbBoth);
        tvResult        = (TextView) findViewById(R.id.tvResult);
    }

    private void setFormat(){

        tvResult.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tvResult.setTextColor(Color.parseColor("#000000"));
        tvResult.setGravity(Gravity.LEFT);

        // Background
        if(ckbBackground.isChecked()){
            tvResult.setBackgroundColor(Color.parseColor("#FFFF00"));
        }

        // Text Color
        if(ckbTextColor.isChecked()){
            tvResult.setTextColor(Color.parseColor("#DF0101"));
        }

        // Center
        if(ckbTextCenter.isChecked()){
            tvResult.setGravity(Gravity.CENTER);
        }
    }

    private void setContent(){
        Random random   = new Random();
        int number      = random.nextInt(100);

        if(rdbOdd.isChecked()) {    // Số lẻ
            while(number % 2 == 0){
                number      = random.nextInt(100);
            }
        }

        if(rdbEven.isChecked()) {    // Số lẻ
            while(number % 2 != 0){
                number      = random.nextInt(100);
            }
        }

        tvResult.setText(number + "");

    }

    private void setContent2(){
        Random random   = new Random();
        int number      = random.nextInt(100);

        int checkedID   = rdgNumberType.getCheckedRadioButtonId();

        switch (checkedID){
            case R.id.rdbOdd:
                while(number % 2 == 0){
                    number      = random.nextInt(100);
                }
                break;
            case R.id.rdbEven:
                while(number % 2 != 0){
                    number      = random.nextInt(100);
                }
                break;
        }

        tvResult.setText(number + "");

    }
    public void showResult(View v){
        if(v.getId() == R.id.btnShow){
            setFormat();
            setContent2();
        }
    }
}
