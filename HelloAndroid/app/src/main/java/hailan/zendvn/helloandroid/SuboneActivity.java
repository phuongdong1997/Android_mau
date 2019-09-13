package hailan.zendvn.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SuboneActivity extends Activity implements View.OnClickListener {

    Button btnOneGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subone);

        btnOneGoBack = (Button) findViewById(R.id.btnOneGoBack);
        btnOneGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOneGoBack:
                finish();
                break;
        }
    }

}
