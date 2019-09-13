package android.training.memenu;

import android.app.ActionBar;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult    = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_search:
//                tvResult.setText("action_search");
//                break;
//            case R.id.action_share:
//                tvResult.setText("action_share");
//                break;
//            case R.id.action_settings:
//                tvResult.setText("action_settings");
//                break;
//            case R.id.action_about:
//                tvResult.setText("action_about");
//                break;
//            case R.id.action_about_me:
//                tvResult.setText("action_about_me");
//                break;
//            case R.id.action_about_app:
//                tvResult.setText("action_about_app");
//                break;
//        }
        tvResult.setText(item.getTitle().toString());
        return super.onOptionsItemSelected(item);
    }

    // Hiển thị thông báo với Toast
    public void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}
