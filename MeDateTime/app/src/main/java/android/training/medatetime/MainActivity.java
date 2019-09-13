package android.training.medatetime;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private EditText edtStart;
    private EditText edtEnd;
    private Button btnShow;
    private DatePickerDialog datePickerDialogStart;
    private DatePickerDialog datePickerDialogEnd;
    private SimpleDateFormat dateFormat;
    private Calendar calendarStart;
    private Calendar calendarEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kết nối các control từ layout đến các biến toàn cục
        init();

        dateFormat  = new SimpleDateFormat("dd/MM/yyyy");
        creatDatePickerDialog();




    }

    private void creatDatePickerDialog(){
        Calendar now            = Calendar.getInstance();

        datePickerDialogStart   = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendarStart.set(year, monthOfYear, dayOfMonth);
                edtStart.setText(dateFormat.format(calendarStart.getTime()).toString()); // 07/10/2015
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH) );

        datePickerDialogEnd   = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendarEnd.set(year, monthOfYear, dayOfMonth);
                edtEnd.setText(dateFormat.format(calendarEnd.getTime()).toString()); // 07/10/2015
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH) );
    }

    private void init() {
        edtStart    = (EditText) findViewById(R.id.edtStart);
        edtEnd      = (EditText) findViewById(R.id.edtEnd);
        tvResult    = (TextView) findViewById(R.id.tvResult);
        btnShow     = (Button) findViewById(R.id.btnShow);

        btnShow.setOnClickListener(this);
        edtStart.setOnClickListener(this);
        edtEnd.setOnClickListener(this);
        edtStart.requestFocus();

        calendarStart  = Calendar.getInstance();
        calendarEnd   = Calendar.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edtStart:
                datePickerDialogStart.show();
                break;
            case R.id.edtEnd:
                datePickerDialogEnd.show();
                break;
            case R.id.btnShow:
                showDistance();
                break;
        }
    }

    public void showDistance(){
        String strResult    = null;

       if(TextUtils.isEmpty(edtStart.getText()) || TextUtils.isEmpty(edtEnd.getText())) {
           strResult    = "Chọn ngày bắt đầu và ngày kết thúc";
       }else{
           int dayCount = (int) ((calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis())/ (24 * 60 * 60 * 1000));
           if(dayCount < 0) {
               strResult    = "Ngày kết thúc phải sau ngày bắt đầu";
           }else{
               strResult    = "Khoảng cách giữa 2 mốc thời gian là: " + dayCount + " ngày";
           }

       }

        tvResult.setText(strResult);
    }

    public void studyCalendar(){

        Calendar now    = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat   = new SimpleDateFormat("hh:mm:ss a");

        tvResult.setText(now.get(Calendar.YEAR) + "");
        tvResult.setText(now.get(Calendar.MONTH) + 1 + "");
        tvResult.setText(simpleDateFormat.format(now.getTime()).toString()); // 23/02/1989
    }

}
