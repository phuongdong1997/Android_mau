package hailan.zendvn.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Format code          CTRL + ALT + L
    // Generate method	    ALT + Insert (Win)
    // Delete line	        CTRL + Y (Win)
    // Copy line            CTRL + D
    // Navigate open tabs	ALT + left-arrow; ALT + right-arrow (Win)
    // Comment             CTRL + /

//    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tvHello = (TextView) findViewById(R.id.textViewHello);
//        tvHello.setText("Training Android!");
    }
}
