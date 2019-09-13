package android.training.mecard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends Activity{

    private TextView tvResult;
    private ImageView ivOne, ivTwo, ivThree;
    private Button btnPlayAgain, btnResult;
    private String[] cardType   = {"clubs", "spades", "diamonds", "hearts"};
    private int[] cardNumber    = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private ArrayList<String> listCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        tvResult        = (TextView) findViewById(R.id.tvResult);
        ivOne           = (ImageView) findViewById(R.id.ivOne);
        ivTwo           = (ImageView) findViewById(R.id.ivTwo);
        ivThree         = (ImageView) findViewById(R.id.ivThree);
        btnResult       = (Button) findViewById(R.id.btnResult);
        btnPlayAgain    = (Button) findViewById(R.id.btnPlayAgain);

        listCards       = new ArrayList<String>();
        View.OnClickListener ivClickChangeCard  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView) v;

                int randCardType    = createRandomNumber(0, 3);
                int randCardNumber  = createRandomNumber(0, 12);

                String cardValue    = cardType[randCardType] + "_" + cardNumber[randCardNumber];

                while (listCards.contains(cardValue)){
                    randCardType    = createRandomNumber(0, 3);
                    randCardNumber  = createRandomNumber(0, 12);
                    cardValue    = cardType[randCardType] + "_" + cardNumber[randCardNumber];
                }

                listCards.add(cardValue);

                int id              = getResources().getIdentifier(cardValue, "drawable", getPackageName());
                imageView.setImageResource(id);

                imageView.setClickable(false);
            }
        };

        ivOne.setOnClickListener(ivClickChangeCard);
        ivTwo.setOnClickListener(ivClickChangeCard);
        ivThree.setOnClickListener(ivClickChangeCard);
    }

    // Show Result
    public void showResult(View v){
        if(listCards.size() < 3){
            tvResult.setText("Mở tất cả 3 lá bài!");
        }else{
            int score   = 0;
            Iterator<String> itr = listCards.iterator();
            while(itr.hasNext()){
                score += getScoreInCard(itr.next());
            }
            // 13   3
            // 27   7
            tvResult.setText(String.format("Score: %d", score % 10));
        }
    }

    private int getScoreInCard(String cardName){
        // spades_2 diamonds_5 hearts_12    = 7
        String[] parts  = cardName.split("_");
        int value       = Integer.parseInt(parts[1]);
        if(value >= 10) value = 0;
        return value;
    }


    // Play Again
    public void playAgain(View v){
        ivOne.setImageResource(R.drawable.card_down);
        ivTwo.setImageResource(R.drawable.card_down);
        ivThree.setImageResource(R.drawable.card_down);

        ivOne.setClickable(true);
        ivTwo.setClickable(true);
        ivThree.setClickable(true);
        tvResult.setText("Score: 0");

        listCards.clear();
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

    // Thiết lập con số ngẫu nhiên
    public int createRandomNumber(int from, int to){
        // from to
        // from + rndGenerator.nextInt(to - from + 1)

        Random rndGenerator = new Random();
        return from + rndGenerator.nextInt(to - from + 1);
    }
}
