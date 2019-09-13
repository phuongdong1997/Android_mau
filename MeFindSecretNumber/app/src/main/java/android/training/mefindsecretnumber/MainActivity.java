package android.training.mefindsecretnumber;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends Activity{

    private TableLayout tblNumber;
    private TextView tvResult;
    private Button btnPlayAgain;
    private int secrectNumber;
    private ArrayList<Button> listButtons;
    private int score = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thiết lập số ngẫu nhiên
        setSecrectNumber();

        init();

        // Hiển thị giá trị điểm  ban đầu
        tvResult.setText("Score: " + score);

        // Create list button
        listButtons = new ArrayList<Button>();

        // Create table number
        createTableNumber();
    }

    private void init(){
        tblNumber       = (TableLayout) findViewById(R.id.tableNumber);
        tvResult        = (TextView) findViewById(R.id.tvResult);
        btnPlayAgain    = (Button) findViewById(R.id.btnPlayAgain);
    }

    // Create table number
    public void createTableNumber(){

        View.OnClickListener btnClick   = new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Button btnTemp  = (Button) v;
                int numberValue = Integer.parseInt(btnTemp.getText().toString());

                if(numberValue > secrectNumber){
                    for(int i = numberValue - 1; i < listButtons.size(); i++){
                        disableButton(listButtons.get(i));
                    }
                }else if (numberValue < secrectNumber){
                    for(int i = numberValue - 1; i >= 0; i--){
                        disableButton(listButtons.get(i));
                    }
                }else{
                    for(int i = 0; i < listButtons.size(); i++){
                        disableButton(listButtons.get(i));
                    }
                    btnTemp.setTextColor(Color.parseColor("#DF013A"));
                }

                score -= 1;
                tvResult.setText("Score: " + score);
                if(score == 0&&numberValue!=secrectNumber) {
                    gameOver();

                }

            }
        };

        for(int i = 1; i <= 8; i++){
            TableRow tblRow = new TableRow(this);

            for(int j = 1; j <= 5; j++){
                Button btnObjNumber = new Button(this);
                int btnValue        = 5 * (i-1) + j;

                btnObjNumber.setText(btnValue + "");
                btnObjNumber.setTextColor(Color.parseColor("#0B0B61"));
                btnObjNumber.setOnClickListener(btnClick);

                listButtons.add(btnValue - 1, btnObjNumber);
                tblRow.addView(btnObjNumber);
            }

            tblNumber.addView(tblRow);
        }
    }

    // Game Over
    public void gameOver(){
        for(int i = 0; i < listButtons.size(); i++){
            disableButton(listButtons.get(i));
        }
        listButtons.get(secrectNumber-1).setTextColor(Color.parseColor("#DF013A"));
        tvResult.setText("Game Over!");
    }
    // Play Again
    public void playAgain(View v){

        // Thay đổi lại số ngẫu nhiên
        setSecrectNumber();

        // Reset giá trị điểm về giá trị ban đầu
        score   = 5;

        // Thay đổi điểm ban đầu
        tvResult.setText("Score: " + score);

        // Thay đổi màu cho toàn bộ button
        Iterator<Button> itr    = listButtons.iterator();
        while (itr.hasNext()){
            Button btnTemp  = itr.next();
            btnTemp.setTextColor(Color.parseColor("#0B0B61"));
            btnTemp.setClickable(true);
        }
    }

    // Disable Button
    public void disableButton(Button btn){
        btn.setClickable(false);
        btn.setTextColor(Color.parseColor("#D8D8D8"));
    }

    // Hiển thị bàn phím
    public void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(this.getCurrentFocus(), InputMethodManager.SHOW_IMPLICIT);
    }

    // Ẩn bàn phím
    public void hideKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
    }

    // Hiển thị thông báo với Toast
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    // Thiết lập con số bí mật
    public void setSecrectNumber(){
        // from to
        // from + rndGenerator.nextInt(to - from + 1)
        // 1 40
        Random rndGenerator = new Random();
        secrectNumber       = 1 + rndGenerator.nextInt(40);
    }
}
