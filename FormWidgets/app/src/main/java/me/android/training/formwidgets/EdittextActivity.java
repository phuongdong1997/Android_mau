package me.android.training.formwidgets;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EdittextActivity extends AppCompatActivity {

    private EditText edtOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        edtOne  = (EditText) findViewById(R.id.edtOne);

        edtOne.setInputType(InputType.TYPE_CLASS_TEXT );
    }

}
