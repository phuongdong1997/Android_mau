package android.training.mecaculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView tvResult;
    private EditText edtFirst, edtSecond;
    private Button btnPlus, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        tvResult    = (TextView) findViewById(R.id.tvResult);
        edtFirst    = (EditText) findViewById(R.id.edtFirst);
        edtSecond   = (EditText) findViewById(R.id.edtSecond);
        btnPlus     = (Button) findViewById(R.id.btnPlus);
        btnSub      = (Button) findViewById(R.id.btnSub);
        btnMul      = (Button) findViewById(R.id.btnMul);
        btnDiv      = (Button) findViewById(R.id.btnDiv);

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(TextUtils.isEmpty(edtFirst.getText()) || TextUtils.isEmpty(edtSecond.getText())){
            showToast("Enter number!");
        }else{
            int numberFirst     = Integer.parseInt(edtFirst.getText().toString());
            int numberSecond    = Integer.parseInt(edtSecond.getText() + "");
            int numberResult    = 0;
            String caculate     = null;


            switch (v.getId()){
                case R.id.btnPlus:
                    caculate    = "+";
                    numberResult= numberFirst + numberSecond;
                    break;
                case R.id.btnSub:
                    caculate    = "-";
                    numberResult= numberFirst - numberSecond;
                    break;
                case R.id.btnMul:
                    caculate    = "*";
                    numberResult= numberFirst * numberSecond;
                    break;
                case R.id.btnDiv:
                    caculate    = "/";
                    numberResult= numberFirst / numberSecond;
                    break;
            }

            hideKeyboard();

            tvResult.setText(String.format("%d %s %d = %d", numberFirst, caculate, numberSecond, numberResult));
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
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
