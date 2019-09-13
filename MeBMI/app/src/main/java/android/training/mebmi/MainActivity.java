package android.training.mebmi;

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
import java.text.DecimalFormat;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView tvResult;
    private EditText edtHeight, edtWeight;
    private Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        tvResult    = (TextView) findViewById(R.id.tvResult);
        edtHeight   = (EditText) findViewById(R.id.edtHeight);
        edtWeight   = (EditText) findViewById(R.id.edtWeight);
        btnView     = (Button) findViewById(R.id.btnView);

        btnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(edtHeight.getText()) || TextUtils.isEmpty(edtWeight.getText())){
            showToast("Enter number!");
        }else{
            if(v.getId() ==  R.id.btnView){
                int height          = Integer.parseInt(edtHeight.getText().toString());
                int weight          = Integer.parseInt(edtWeight.getText() + "");
                float bmi           = caculateBMI(weight, height);
                int bestWeight      = (height % 100) * 9 / 10;
                String advice       = getAdvice(bestWeight, weight);

                String result, record1, record2, record3;

                record1 = String.format("Chỉ số BMI của bạn: %.2f %n", bmi) ;
                record2 = convertBMI(bmi);
                record3 = String.format("%nCân nặng lý tưởng của bạn: %d kg (%s)%n", bestWeight, advice) ;


                result  = record1 + record2 + record3;
                tvResult.setText(result);

                hideKeyboard();
            }
        }
    }

    public String getAdvice(int bestWeight, int weight){
        String result = "Thân hình lý tưởng";

        if(bestWeight > weight){
            result = String.format("Bạn thiếu %d kg", bestWeight - weight);
        }else if(bestWeight < weight){
            result = String.format("Bạn thừa %d kg",weight - bestWeight);
        }

        return result;
    }

    public String convertBMI(float bmiValue){
        String result = null;

        if (bmiValue < 18.5) {
            result = "Bạn bị thiếu cân";
        } else if (bmiValue < 25) {
            result =  "Thân hình bạn hoàn toàn bình thường";
        } else if (bmiValue < 30) {
            result = "Bạn bị béo phì cấp độ I";
        } else if (bmiValue < 40) {
            result = "Bạn bị béo phì cấp độ II";
        } else {
            result = "Bạn bị béo phì cấp độ III";
        }

        return result;

    }

    public float caculateBMI(float weight, float height){
        return (weight) / (height/100 * height/100);
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


// BMI = (weight) / (height * height)
//       Weight có đơn vị kg – Height có đơn vị là m

// < 18.5 Bạn bị thiếu cân
// < 25 Thân hình bạn hoàn toàn bình thường
// < 30 Bạn bị béo phì cấp độ I
// < 40 Bạn bị béo phì cấp độ II
// > 40 Bạn bị béo phì cấp độ III


// Tính cân lý tưởng: Số lẻ của chiều cao (tính bằng cm) x 9 rồi chia cho 10
// Mức cân tối đa: Bằng số lẻ của chiều cao
// Mức cân tối thiểu: Số lẻ của chiều cao (tính bằng cm) x 8 chia cho 10


