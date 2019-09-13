package me.android.training.formwidgets;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class ExerciseActivity extends AppCompatActivity {

    private EditText edtYourInput;
    private Button btnShow;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        edtYourInput    = (EditText) findViewById(R.id.edtInput);
        btnShow         = (Button) findViewById(R.id.btnShow);
        tvResult         = (TextView) findViewById(R.id.tvResult);

    }

    public void showContent(View v){
        tvResult.setText(edtYourInput.getText().toString());
    }

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
