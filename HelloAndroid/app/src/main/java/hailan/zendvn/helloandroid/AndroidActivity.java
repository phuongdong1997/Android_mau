package hailan.zendvn.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class AndroidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        Log.d("trainingAndroid", "onCreate");
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
