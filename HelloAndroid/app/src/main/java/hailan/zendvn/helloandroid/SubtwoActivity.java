package hailan.zendvn.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SubtwoActivity extends Activity implements View.OnClickListener{

    Button btnTwoGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtwo);

        btnTwoGoBack = (Button) findViewById(R.id.btnTwoGoBack);
        btnTwoGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTwoGoBack:
                finish();
                break;
        }
    }

}
