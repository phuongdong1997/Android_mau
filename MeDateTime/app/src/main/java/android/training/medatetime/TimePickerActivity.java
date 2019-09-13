package android.training.medatetime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvResult;
    private Button btnShow;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        init();

        createTimePickerDialog();
    }

    private void init() {
        tvResult    = (TextView) findViewById(R.id.tvResult);
        btnShow     = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
    }

    private void createTimePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(TimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                showTime(hourOfDay, minute);
            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);


    }

    // 00:14    12:14 AM    hour = 0
    // 12:15    12:15 PM    hour = 12
    // 14:20    2:20 PM     hour > 12
    // 3:40     3:40 AM     hour < 12

    public void showTime(int hour, int min) {
        String format = null;
        if(hour == 0){
            hour    = 12;
            format  = "AM";
        }else if (hour == 12){
            format  = "PM";
        }else if (hour > 12){
            hour    = hour - 12;
            format  = "PM";
        }else{
            format  = "AM";
        }



        tvResult.setText(hour + " : " + min + " " + format);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnShow:
                timePickerDialog.show();
                break;
        }
    }

}
