package android.training.mequotations;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    Button btnShowResult;
    TextView tvResult;
    ArrayList<String> listQuotations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        tvResult        = (TextView) findViewById(R.id.tvResult);
        btnShowResult   = (Button) findViewById(R.id.btnShowResult);

        listQuotations  = new ArrayList<String>();
        listQuotations.add("I have learned more from my failures than from my success");
        listQuotations.add("Learn to be happy with what you have while you pursue all that you dream");
        listQuotations.add("Success is the ability to go from one failure to another with no loss of enthusiasm");
    }

    public void showQuotation(View v){
        if(v.getId() == R.id.btnShowResult){


            btnShowResult.setClickable(false);
            btnShowResult.setVisibility(View.INVISIBLE);

            CountDownTimer countDownTimer   = new CountDownTimer(10000, 2000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    Random randomGenerator  = new Random();

                    // Text Color
                    tvResult.setTextColor(Color.rgb(randomGenerator.nextInt(265),randomGenerator.nextInt(265),randomGenerator.nextInt(265)));

                    // Text Size
                    tvResult.setTextSize(randomGenerator.nextInt(20) + 20);

                    // Gravity
                    switch (randomGenerator.nextInt(3)){
                        case 0:  tvResult.setGravity(Gravity.CENTER); break;
                        case 1:  tvResult.setGravity(Gravity.LEFT); break;
                        case 2:  tvResult.setGravity(Gravity.RIGHT); break;
                    }

                    // TEXT
                    tvResult.setText(listQuotations.get(randomGenerator.nextInt(listQuotations.size())) + "");
                }

                @Override
                public void onFinish() {
                    btnShowResult.setClickable(true);
                    btnShowResult.setVisibility(View.VISIBLE);
                }
            };

            countDownTimer.start();

        }
    }

    // Hiển thị thông báo với Toast
    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}