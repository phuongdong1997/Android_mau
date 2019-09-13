package android.training.meresources;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Resources resources=  getResources();

        String strOne      = "Android";
        tvResult.setText(String.format(resources.getString(R.string.my_str),strOne, 890));

        getResources().getColor(R.color.color_two);

        getResources().getDimension(R.dimen.activity_item_distance);

    }

    private void init(){
        tvResult    = (TextView) findViewById(R.id.tvResult);
    }
}
