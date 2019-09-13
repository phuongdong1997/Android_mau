package me.android.training.formwidgets;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class TextviewActivity extends AppCompatActivity {

    private TextView tvOne;
    private TextView tvTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        tvOne   = (TextView) findViewById(R.id.tvOne);
        tvOne.setText("Hello Android");
        showToast(tvOne.getText().toString());


        tvTwo   = (TextView) findViewById(R.id.tvTwo);
        tvTwo.setText("Hello Android 2");
        tvTwo.setGravity(Gravity.CENTER_HORIZONTAL);
        tvTwo.setBackgroundColor(Color.parseColor("#F5FBEF"));
        tvTwo.setAllCaps(true);
        tvTwo.setTypeface(tvTwo.getTypeface(), Typeface.BOLD_ITALIC);
    }

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
