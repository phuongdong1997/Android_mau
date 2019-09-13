package android.training.eventlisteners;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.myevent.*;

public class MainActivity extends Activity implements View.OnClickListener{

    TextView textViewResult;
    Button btnTwo, btnThree, btnFour, btnFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        // Button 2
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText("Inline anonymous listener");
            }
        });

        // Button 3
        btnThree.setOnClickListener(this);

        // Button 4
        View.OnClickListener btnClick   = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textViewResult.setText("Listener is variable");
            }
        };
        btnFour.setOnClickListener(btnClick);

        // Button 5
        btnFive.setOnClickListener(new EventButton());
    }

    public void init(){
        btnTwo          = (Button) findViewById(R.id.btnTwo);
        btnThree        = (Button) findViewById(R.id.btnThree);
        btnFour         = (Button) findViewById(R.id.btnFour);
        btnFive         = (Button) findViewById(R.id.btnFive);
        textViewResult  = (TextView) findViewById(R.id.tvResult);
    }

    // Inline listener
    public void inlineListener(View v){
        switch (v.getId()){
            case R.id.btnOne:
                textViewResult.setText("Inline listener");
                break;
            case R.id.btnTwo:
                textViewResult.setText("Inline anonymous listener");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThree:
                textViewResult.setText("Activity is listener");
                break;
            case R.id.btnFour:
                textViewResult.setText("Listener in variable");
                break;
        }
    }
}

