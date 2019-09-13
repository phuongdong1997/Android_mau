package android.training.virtualkeyboard;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnShow, btnHide;
    private EditText edtOne, edtTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        init();
    }

    private void init(){
        edtOne      = (EditText) findViewById(R.id.edtOne);
        edtTwo      = (EditText) findViewById(R.id.edtTwo);
        btnShow     = (Button) findViewById(R.id.btnShow);
        btnHide     = (Button) findViewById(R.id.btnHide);

        btnShow.setOnClickListener(this);
        btnHide.setOnClickListener(this);

        edtTwo.requestFocus();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnShow) {
            showKeyboard();
        } else if (v.getId()==R.id.btnHide) {
            hideKeyboard();
        }
    }


    public void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(this.getCurrentFocus(), InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
    }




    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}