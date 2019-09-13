package android.training.medialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogFour();
            }
        });
    }

    private void createDialogFour(){
        Dialog customDialog = new Dialog(MainActivity.this);
        customDialog.setContentView(R.layout.dialog);
        customDialog.setTitle("Your Character");
        customDialog.setCanceledOnTouchOutside(true);

        ImageView imageViewSongoku      = (ImageView) customDialog.findViewById(R.id.imgSongoku);
        ImageView imageViewPikachu      = (ImageView) customDialog.findViewById(R.id.imgPikachu);
        ImageView imageViewDoremon      = (ImageView) customDialog.findViewById(R.id.imgDoremon);

        imageViewSongoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Songoku");
            }
        });

        imageViewPikachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Pikachu");
            }
        });

        imageViewDoremon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Doremon");
            }
        });

        customDialog.show();
    }

    private void createDialogThree(){
        final String[] arrCourse      = {"Android", "Java", "PHP"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("AlertDialog Training");
        builder.setIcon(android.R.drawable.ic_media_next);
        builder.setItems(arrCourse, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(arrCourse[which].toString());
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    private void createDialogSecond(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("AlertDialog Training");
        builder.setMessage("AlertDialog is very easy!");
        builder.setIcon(android.R.drawable.ic_media_next);

        builder.setPositiveButton("Chấp nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("YES");
            }
        });

        builder.setNegativeButton("Từ chối", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    private void createDialogFirst(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("AlertDialog Training");
        builder.setMessage("AlertDialog is very easy!");
        builder.setIcon(android.R.drawable.ic_media_next);

        AlertDialog alertDialog = builder.create();

        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
