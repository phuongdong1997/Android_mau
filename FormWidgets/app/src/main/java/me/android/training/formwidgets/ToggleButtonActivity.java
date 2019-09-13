package me.android.training.formwidgets;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonMe);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    showToast("BẬT");
                }else{
                    showToast("TẮT");
                }
            }
        });
    }

    public void showContent(View v){
        boolean checked = ((ToggleButton)v).isChecked();
        if(checked) {
            showToast("Bạn chọn BẬT");
        }else{
            showToast("Bạn chọn TẮT");
        }
    }

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
