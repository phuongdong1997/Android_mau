package hailan.zendvn.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifetimeActivity extends Activity implements View.OnClickListener {

    Button btnChildOne, btnChildTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifetime);

        Log.d("trainingAndroid", "onCreate");

        btnChildOne = (Button) findViewById(R.id.btnShowChildOne);
        btnChildTwo = (Button) findViewById(R.id.btnShowChildTwo);

        btnChildOne.setOnClickListener(this);
        btnChildTwo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnShowChildOne:
                Toast.makeText(getApplicationContext(), "btnShowChildOne", Toast.LENGTH_LONG).show();
                Intent intentOne   = new Intent(LifetimeActivity.this, SuboneActivity.class);
                startActivity(intentOne);
                break;
            case R.id.btnShowChildTwo:
                Toast.makeText(getApplicationContext(), "btnShowChildTwo", Toast.LENGTH_LONG).show();
                Intent intentTwo   = new Intent(LifetimeActivity.this, SubtwoActivity.class);
                startActivity(intentTwo);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("trainingAndroid", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("trainingAndroid", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("trainingAndroid", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("trainingAndroid", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("trainingAndroid", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("trainingAndroid", "onDestroy");
    }
}
